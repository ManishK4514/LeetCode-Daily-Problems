//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {

		Scanner sc=new Scanner(System.in);
		int test=sc.nextInt();
		while(test-- > 0){
		    int p=sc.nextInt();             // Take size of both the strings as input
		    int q=sc.nextInt();
		    
		    String s1=sc.next();            // Take both the string as input
	        String s2=sc.next();
		    
		    Solution obj = new Solution();
		    
		    System.out.println(obj.lcs(p, q, s1, s2));
		}
	}
}
// } Driver Code Ends


class Solution
{
    //Function to find the length of longest common subsequence in two strings.
    public static int helper(String text1, String text2, int i, int j, int[][] dp){
        if(i < 0 || j < 0) return 0;
        int ans;
        if(dp[i][j] != -1) return dp[i][j];
        if(text1.charAt(i) == text2.charAt(j)){
            ans = 1 + helper(text1, text2, i - 1, j - 1, dp);
        }
        else{
            ans = Math.max(helper(text1, text2, i - 1, j, dp), helper(text1, text2, i,j - 1, dp));
        }
        dp[i][j] = ans;
        return dp[i][j];
    }
    static int lcs(int x, int y, String text1, String text2) {
        int n = text1.length(), m = text2.length();
        int[][] dp = new int[text1.length()][text2.length()];
        for(int[] nums : dp){
            Arrays.fill(nums, -1);
        }
        return helper(text1, text2, n - 1, m - 1, dp);
    }
    
}