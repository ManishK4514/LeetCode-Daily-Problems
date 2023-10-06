class Solution {
    public int helper(int n, int k, int[][] dp) {
        if(dp[n][k] != -1) return dp[n][k];

        int ans = 0;

        for(int i = 1; i < n; i++) {            
            ans = Math.max(ans, i * helper(n - i, (k == 1 ? k : k + 1), dp));
        }

        if(k >= 1) ans = Math.max(ans, n);

        return dp[n][k] = ans;
    }
    public int integerBreak(int n) {
        int[][] dp = new int[n + 1][2];
        for(int[] it : dp) Arrays.fill(it, -1);
        return helper(n, 0, dp);
    }
}