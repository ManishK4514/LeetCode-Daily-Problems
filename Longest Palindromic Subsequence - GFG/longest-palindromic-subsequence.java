//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Solution obj = new Solution();
                    System.out.println(obj.longestPalinSubseq(s));
                }
                
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{   
    public int helper(String s, int i, int j, int[][] dp){
        if(i == j) return 1;

        if(dp[i][j] != -1) return dp[i][j];

        // if length is 2 and both charcter are equals
        if((j - i + 1) == 2 && s.charAt(i) == s.charAt(j)) return 2;
        
        // if first and last characters are equal then call for the remaining string
        if(s.charAt(i) == s.charAt(j)) {
            return dp[i][j] = 2 + helper(s, i + 1, j - 1, dp);
        }

        return dp[i][j] = Math.max(helper(s, i + 1, j, dp), helper(s, i, j - 1, dp));
    }
    public int longestPalinSubseq(String s)
    {
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int[] it : dp) Arrays.fill(it, -1);
        return helper(s, 0, n - 1, dp);
    }
}