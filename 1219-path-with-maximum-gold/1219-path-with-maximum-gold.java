class Solution {
    public int helper(int row, int col, int[][] grid, int[] delRow, int[] delCol) {
        int n = grid.length, m = grid[0].length;

        int ans = grid[row][col];
        int currVal = grid[row][col];
        grid[row][col] = 0;
        
        for(int i = 0; i < 4; i++) {
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];

            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] != 0) {
                ans = Math.max(ans, currVal + helper(nrow, ncol, grid, delRow, delCol));
            }
        }

        grid[row][col] = currVal;

        return ans;
    }
    public int getMaximumGold(int[][] grid) {
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        int n = grid.length, m = grid[0].length, ans = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] != 0) {
                    ans = Math.max(ans, helper(i, j, grid, delRow, delCol));
                }
            }
        }

        return ans;
    }
}