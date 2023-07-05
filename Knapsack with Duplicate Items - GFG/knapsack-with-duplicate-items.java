//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String line1[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(line1[0]);
            int W = Integer.parseInt(line1[1]);
            String line2[] = in.readLine().trim().split("\\s+");
            int val[] = new int[N];
            for(int i = 0;i < N;i++)
                val[i] = Integer.parseInt(line2[i]);
            String line3[] = in.readLine().trim().split("\\s+");
            int wt[] = new int[N];
            for(int i = 0;i < N;i++)
                wt[i] = Integer.parseInt(line3[i]);
                
            Solution ob = new Solution();
            System.out.println(ob.knapSack(N, W, val, wt));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public static int helper(int i, int[] val, int[] wt, int W, int[][] dp){
        // base case
        if(i == 0) return (W/(wt[0])) * val[0];
        
        if(dp[i][W] != -1) return dp[i][W];
        
        // take
        int take = Integer.MIN_VALUE;
        if(wt[i] <= W) take = val[i] + helper(i, val, wt, W - wt[i], dp);
        
        // not take
        int notTake = helper(i - 1, val, wt, W, dp);
        
        return dp[i][W] = Math.max(take, notTake);
    }
    
    public static int knapSack(int N, int W, int val[], int wt[]) {
        int[][] dp = new int[N][W + 1];
        for(int[] it : dp) Arrays.fill(it, -1);
        int ans = helper(N - 1, val, wt, W, dp);
        return ans == Integer.MIN_VALUE ? 0 : ans;
    }
}