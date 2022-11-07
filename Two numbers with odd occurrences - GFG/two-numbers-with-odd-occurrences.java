//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int Arr[]= new int[N];
            for(int i = 0; i < N; i++)
                Arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int[] ans = ob.twoOddNum(Arr,N);
            for(int i = 0; i < ans.length; i++)
            {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

//User function Template for Java
class Solution
{
    public int[] twoOddNum(int nums[], int N)
    {
        ArrayList<Integer> temp = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            if(entry.getValue() % 2 != 0){
                temp.add(entry.getKey());
            }
        }
        int[] arr = new int[2];
        int j = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(!set.contains(nums[i]) && temp.contains(nums[i])){
                arr[j++] = nums[i];
                set.add(nums[i]);
            }
        }
        if(arr[0] < arr[1]){
            int temp1 = arr[0];
            arr[0] = arr[1];
            arr[1] = temp1;
        }
        return arr;
    }
}