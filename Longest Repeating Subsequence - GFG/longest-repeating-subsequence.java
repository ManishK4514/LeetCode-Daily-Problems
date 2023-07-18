//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String str = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.LongestRepeatingSubsequence(str);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int helper(int i, int j, String str, int[][] dp){
        if(i == 0 || j == 0) return 0;
        
        if(dp[i][j] != -1) return dp[i][j];
        
        if(str.charAt(i - 1) == str.charAt(j - 1) && i != j){
            return dp[i][j] = 1 + helper(i - 1, j - 1, str, dp);
        }
        else return dp[i][j] = Math.max(helper(i - 1, j, str, dp), helper(i, j - 1, str, dp));
    }
    public int LongestRepeatingSubsequence(String str){
        int n = str.length();
        int[][] dp = new int[n + 1][n + 1];
        for(int[] it : dp) Arrays.fill(it, -1);
        return helper(n, n, str, dp);
    }
}