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
    public int helper(int i, int j, String s, int[][] dp){
        if(i == j) return 1;
        
        if(j - i == 1 && s.charAt(i) == s.charAt(j)) return 2;
        
        if(dp[i][j] != -1) return dp[i][j];
        
        if(s.charAt(i) == s.charAt(j)){
            return dp[i][j] = 2 + helper(i + 1, j - 1, s, dp);
        }
        else return dp[i][j] = Math.max(helper(i + 1, j, s, dp), helper(i, j - 1, s, dp));
    }
    public int longestPalinSubseq(String S)
    {
        int n = S.length();
        int[][] dp = new int[n][n];
        for(int[] it : dp) Arrays.fill(it, -1);
        return helper(0, S.length() - 1, S, dp);
    }
}