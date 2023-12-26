class Solution {
    public int helper(int n, int k, int target, int[][] dp) {
        if(n == 0) return target == 0 ? 1 : 0;

        if(dp[n][target] != -1) return dp[n][target];

        int ans = 0;

        for(int i = 1; i <= k; i++) {
            if(i <= target) {
                ans = (ans + helper(n - 1, k, target - i, dp)) % (int)(1e9 + 7);
            }
            else break;
        }

        return dp[n][target] = ans % (int)(1e9 + 7);
    }

    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp = new int[n + 1][target + 1];
        for(int[] it : dp) Arrays.fill(it, -1);
        return helper(n, k, target, dp);
    }
}