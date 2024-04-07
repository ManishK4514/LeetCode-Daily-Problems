class Solution {
    public boolean helper(String s, int i, int open, int close, Boolean[][][] dp) {
        if(i == s.length()) return open == close;

        if(close > open) return false;

        if(dp[i][open][close] != null) return dp[i][open][close];
        
        boolean possible = false;

        if(s.charAt(i) == '(') possible |= helper(s, i + 1, open + 1, close, dp);
        else if(s.charAt(i) == ')') possible |= helper(s, i + 1, open, close + 1, dp);
        else {
            possible |= helper(s, i + 1, open + 1, close, dp);
            possible |= helper(s, i + 1, open, close + 1, dp);
            possible |= helper(s, i + 1, open, close, dp);
        }

        return dp[i][open][close] = possible;
    }
    public boolean checkValidString(String s) {
        int n = s.length();
        Boolean[][][] dp = new Boolean[n + 1][n + 1][n + 1];
        return helper(s, 0, 0, 0, dp);
    }
}