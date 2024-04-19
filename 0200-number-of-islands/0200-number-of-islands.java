class Solution {
    public void dfs(char[][] grid, int row, int col, int[] delRow, int[] delCol) {
        int n = grid.length, m = grid[0].length;
        
        for(int i = 0; i < 4; i++) {
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];

            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == '1'){
                grid[nrow][ncol] = '0';
                dfs(grid, nrow, ncol, delRow, delCol);
            }
        }
    }
    public int numIslands(char[][] grid) {
        int n = grid.length, m = grid[0].length, island = 0;

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == '1') {
                    dfs(grid, i, j, delRow, delCol);
                    island++;
                }
            }
        }

        return island;
    }
}