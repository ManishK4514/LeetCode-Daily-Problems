//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String A = br.readLine().trim();
            Solution ob = new Solution();
            String ans = ob.FirstNonRepeating(A);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution
{
    public String FirstNonRepeating(String A)
    {
        int[] map = new int[26];
        Queue<Character> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < A.length(); i++){
            char ch = A.charAt(i);
            map[A.charAt(i) - 'a']++;
            if(q.isEmpty()){
                if(map[ch - 'a'] == 1){
                    q.add(ch);
                    sb.append(ch);
                }
                else sb.append("#");
            }
            else{
                while(!q.isEmpty() && map[q.peek() - 'a'] > 1){
                    q.remove();
                }
                if(map[ch - 'a'] == 1) q.add(ch);
                if(!q.isEmpty()){
                    sb.append(q.peek());
                }
                else sb.append("#");
            }
        }
        return sb.toString();
    }
}