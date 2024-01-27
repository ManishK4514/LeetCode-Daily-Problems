class Solution {
    public int kInversePairs(int n, int k) {
        long[][] dp = new long[n + 1][k + 1];
        dp[0][0] = 1;

        for(int i = 1; i <= n; i++) {
            long sum = 0;
            for(int j = 0; j <= k; j++) {
                sum += dp[i - 1][j];

                if(j >= i) sum -= dp[i - 1][j - i];
                dp[i][j] = sum % (long)(1e9 + 7);
            }
        }

        return (int)dp[n][k];
    }
}