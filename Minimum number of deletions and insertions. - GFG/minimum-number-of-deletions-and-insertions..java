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
                    String s1 = sc.next();
                    String s2 = sc.next();
                    Solution ob = new Solution();
                    System.out.println(ob.minOperations(s1,s2));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length(), m = text2.length();
   
        // shifting 1-index to the right        
        int[][] dp = new int[n + 1][m + 1];
   
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(text1.charAt(i - 1) == text2.charAt(j - 1)){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
   
        return dp[n][m];
    }
	public int minOperations(String str1, String str2) 
	{ 
	    int n = str1.length();
        int m = str2.length();

        return (n + m) - (2 * longestCommonSubsequence(str1, str2));
	} 
}