class Solution {
    public long helper(int n, int m, int k, int prev, long[][][] dp) {
        if(n == 0) return k == 0 ? 1 : 0;
        if(k < 0) return 0; 

        if(dp[n][k][prev + 1] != -1) return dp[n][k][prev + 1];
        
        long ans = 0, mod = (long)(1e9 + 7);
        for(int i = 1; i <= m; i++) {
            if(i > prev) ans += helper(n - 1, m, k - 1, i, dp);
            else ans += helper(n - 1, m, k, prev, dp);
        }

        return dp[n][k][prev + 1] = ans % mod;
    }
    public int numOfArrays(int n, int m, int k) {
        long[][][] dp = new long[n + 1][k + 1][m + 2];
        for(long[][] it : dp) for(long[] it2 : it) Arrays.fill(it2, -1);
        return (int)helper(n, m, k, -1, dp);
    }
}