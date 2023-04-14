class Solution {
    public int helper(String s, int i, int j, int[][] dp){
        if(i == j) return 1;

        // if there is string of size 2 and both character are equal
        if(j - i == 1 && s.charAt(i) == s.charAt(j)) return 2;
        
        if(dp[i][j] != -1) return dp[i][j];

        // if first and last characters are equal then call for the remaining string
        if(s.charAt(i) == s.charAt(j)){
            return 2 + helper(s, i + 1, j - 1, dp);
        }

        return dp[i][j] = Math.max(helper(s, i + 1, j, dp), helper(s, i, j - 1, dp));
    }
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];
        for(int[] it : dp) Arrays.fill(it, -1); 
        return helper(s, 0, s.length() - 1, dp);
    }
}