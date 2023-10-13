class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];

        for(int i = 1; i <= n; i++) {
            int oneStep = cost[i - 1] + dp[i - 1];
            int twoStep = Integer.MAX_VALUE;
            if(i - 2 >= 0) twoStep = cost[i - 1] + dp[i - 2];
    
            dp[i] = Math.min(oneStep, twoStep);
        }

        return Math.min(dp[n], dp[n - 1]);
    }
}