class Solution {
    public int helper(int row, int col, int[][] grid, int n, int m, int[] delRow, int[] delCol, int[][] dp) {
        if (dp[row][col] != -1) return dp[row][col];
        
        int ans = 0;

        for (int i = 0; i < 3; i++) {
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];

            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] > grid[row][col]) {
                ans = Math.max(ans, 1 + helper(nrow, ncol, grid, n, m, delRow, delCol, dp));
            }
        }
        
        dp[row][col] = ans;
        return ans;
    }
    
    public int maxMoves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[] delRow = {-1, 0, 1};
        int[] delCol = {1, 1, 1};

        int ans = 0;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, helper(i, 0, grid, n, m, delRow, delCol, dp));
        }

        return ans;
    }
}
