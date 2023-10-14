class Solution {
    public int helper(int i, int[] cost, int[] time, int walls, int[][] dp) {
        if(walls <= 0) return 0;
        if(i == cost.length) return (int)(1e9);

        if(dp[i][walls] != -1) return dp[i][walls];

        // Paid Painter will Paint this wall
        int a = cost[i] + helper(i + 1, cost, time, walls - time[i] - 1, dp);

        // free Painter will Paint this wall
        int b = helper(i + 1, cost, time, walls, dp);

        return dp[i][walls] = Math.min(a, b);
    }
    public int paintWalls(int[] cost, int[] time) {
        int totalTime = 0, n = cost.length;

        for(int it : time) totalTime += it;

        int[][] dp = new int[n][n + 1];
        for(int[] it : dp) Arrays.fill(it, -1);

        return helper(0, cost, time, n, dp);
    }
}