class Solution {
    public int helper(int row, int col1, int col2, int[][] grid, int n, int m, int[][][] dp) {
        if(row >= n || col1 < 0 || col1 >= m || col2 < 0 || col2 >= m) return 0;

        if(dp[row][col1][col2] != -1) return dp[row][col1][col2];

        int ans = 0;

        for(int i = -1; i <= 1; i++) {
            for(int j = -1; j <= 1; j++) {
                if(col1 == col2) ans = Math.max(ans, grid[row][col1] + helper(row + 1, col1 + i, col2 + j, grid, n, m, dp));
                else ans = Math.max(ans, grid[row][col1] + grid[row][col2] + helper(row + 1, col1 + i, col2 + j, grid, n, m, dp));                
            }
        }

        return dp[row][col1][col2] = ans;
    }
    public int cherryPickup(int[][] grid) {
        int m = grid[0].length;
        int n = grid.length;
        int[][][] dp = new int[n][m][m];
        for(int[][] it : dp) for(int[] it2 : it) Arrays.fill(it2, -1);
        return helper(0, 0, m - 1, grid, n, m, dp);
    }
}