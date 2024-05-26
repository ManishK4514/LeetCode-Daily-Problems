class Solution {
    public int helper(int n, int absent, int consecutive, int[][][] dp) {
        if(n == 0) return 1;

        if(dp[n][absent][consecutive] != -1) return dp[n][absent][consecutive];

        int ans = 0, mod = (int)(1e9 + 7);

        // absent
        if(absent > 0) ans = (ans + helper(n - 1, absent - 1, 0, dp)) % mod;

        // late
        if(consecutive < 2) {
            ans = (ans + helper(n - 1, absent, consecutive + 1, dp)) % mod;
        }

        // present
        ans = (ans + helper(n - 1, absent, 0, dp)) % mod;

        return dp[n][absent][consecutive] = ans % mod;
    }
    public int checkRecord(int n) {
        int[][][] dp = new int[n + 1][2][4];
        for(int[][]it : dp) for(int[] it2 : it) Arrays.fill(it2, -1);
        return helper(n, 1, 0, dp);
    }
}