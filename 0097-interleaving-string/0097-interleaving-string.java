class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) return false;
        int m = s1.length(), n = s2.length(), o = s3.length();
        boolean[][][] dp = new boolean[m + 1][n + 1][o + 1];

        dp[0][0][0] = true;

        for(int i = 0; i <= m; i++) {
            for(int j = 0; j <= n; j++) {
                for(int k = 1; k <= o; k++) {

                    boolean ans = false;
                    if(i > 0 && s1.charAt(i - 1) == s3.charAt(k - 1)) {
                        ans |= dp[i - 1][j][k - 1];
                    }
                    if(j > 0 && s2.charAt(j - 1) == s3.charAt(k - 1)) {
                        ans |= dp[i][j - 1][k - 1];
                    }
            
                    dp[i][j][k] = ans;
                }
            }
        }

        return dp[m][n][o];
    }
}