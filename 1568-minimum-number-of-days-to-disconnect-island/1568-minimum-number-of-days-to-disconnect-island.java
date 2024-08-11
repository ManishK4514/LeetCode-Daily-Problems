class Solution {
    public void dfs(int row, int col, int[][] grid, int[][] vis, int[] delRow, int[] delCol, int n, int m) {
        vis[row][col] = 1;

        for(int i = 0; i < 4; i++) {
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];

            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1){
                dfs(nrow, ncol, grid, vis, delRow, delCol, n, m);
            }
        }
    }

    public int getComponentCount(int[][] grid) {
        int n = grid.length, m = grid[0].length, count = 0;

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        int[][] vis = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(vis[i][j] == 0 && grid[i][j] == 1) {
                    dfs(i, j, grid, vis, delRow, delCol, n, m);
                    count++;
                }
            }
        }

        return count;
    }

    public int minDays(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int components = getComponentCount(grid);

        if(components != 1) return 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1) {
                    grid[i][j] = 0;
                    if(getComponentCount(grid) != 1) return 1;
                    grid[i][j] = 1;
                }                
            }
        }

        return 2;
    }
}