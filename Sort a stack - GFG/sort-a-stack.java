//{ Driver Code Starts
import java.util.Scanner;
import java.util.Stack;
class SortedStack{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			Stack<Integer> s=new Stack<>();
			int n=sc.nextInt();
			while(n-->0)
			s.push(sc.nextInt());
			GfG g=new GfG();
			Stack<Integer> a=g.sort(s);
			while(!a.empty()){
				System.out.print(a.peek()+" ");
				a.pop();
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


/*Complete the function below*/
class GfG{
	public Stack<Integer> sort(Stack<Integer> s)
	{
		Stack<Integer> st = new Stack<>();
		Stack<Integer> helper = new Stack<>();
		while(!s.empty()){
		    while(!st.empty() && s.peek() < st.peek()){
                helper.push(st.pop());
            }
            if(!s.empty()){
                st.push(s.pop());
            }
            while(!helper.empty()){
                st.push(helper.pop());
            }
		}
		return st;
	}
}