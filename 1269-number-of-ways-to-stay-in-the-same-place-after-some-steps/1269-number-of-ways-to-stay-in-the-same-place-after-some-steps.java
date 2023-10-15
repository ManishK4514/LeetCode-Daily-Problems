class Solution {
    int last = 0;
    public long helper(int i, int n, int steps, long[][] dp) {
        long MOD = 1000000007;

        if(i >= last) return 0;
        
        if(steps == 0) {
            if(i == 0) return 1;
            return 0;
        }

        if(dp[i][steps] != -1) return dp[i][steps];
        
        long left = 0, right = 0, stay = 0;
        if(i - 1 >= 0) left = helper(i - 1, n, steps - 1, dp) % MOD;
        
        if(i + 1 < n) right = helper(i + 1, n, steps - 1, dp) % MOD;

        stay = helper(i, n, steps - 1, dp) % MOD;

        return dp[i][steps] = (left + right + stay) % MOD;
    }

    public int numWays(int steps, int arrLen) {
        long[][] dp = new long[steps/2 + 1][steps + 1];
        for(long[] it : dp) Arrays.fill(it, -1);

        this.last = steps/2 + 1;

        return (int) helper(0, arrLen, steps, dp);
    }
}
