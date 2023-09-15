//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int x = ob.equalPartition(N, arr);
            if(x == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    public static boolean possible(int idx, int[] nums, int target, int[][] dp){
        if(idx < 0){
            if(target == 0) return true;
            return false;
        }
        if(target < 0) return false;
        
        if(dp[idx][target] != -1) return dp[idx][target] == 0 ? false : true;

        // take
        boolean take = possible(idx - 1, nums, target - nums[idx], dp);

        // not take 
        boolean notTake = possible(idx - 1, nums, target, dp);
        
        dp[idx][target] = take || notTake == false ? 0 : 1;
        return take || notTake;
    }
    static int equalPartition(int n, int nums[])
    {
        int sum = 0;
        for(int i = 0; i < n; i++) sum += nums[i];
        if(sum % 2 != 0) return 0;
        int[][] dp = new int[n + 1][(sum/2) + 1];
        for(int[] it : dp) Arrays.fill(it, -1);
        return possible(n - 1, nums, sum/2, dp) ? 1 : 0;
    }
}