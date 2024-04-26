class Solution {
    public int helper(int row, int col, int[][] grid, int n, int[][] dp) {
        if(row == n) return 0;

        if(dp[row][col + 1] != -1) return dp[row][col + 1];

        int ans = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++) {
            if(i == col) continue;
            ans = Math.min(ans, grid[row][i] + helper(row + 1, i, grid, n, dp));
        }

        return dp[row][col + 1] =  ans;
    }
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int[][] dp = new int[n][n + 1];
        for(int[] it : dp) Arrays.fill(it, -1);
        return helper(0, -1, grid, n, dp);
    }
}