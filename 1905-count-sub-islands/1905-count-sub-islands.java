class Solution {
    public boolean dfs(int row, int col, int[][] grid1, int[][] grid2, int[] delRow, int[] delCol, int n, int m, int[][] vis) {
        vis[row][col] = 1;

        boolean ans = true;

        for(int i = 0; i < 4; i++) {
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];

            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && grid2[nrow][ncol] == 1){
                ans &= dfs(nrow, ncol, grid1, grid2, delRow, delCol, n, m, vis);
            }
        }

        return ans && grid1[row][col] == 1;
    }

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int n = grid1.length;
        int m = grid1[0].length;
        int ans = 0;

        int[][] vis = new int[n][m];
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid2[i][j] == 1 && vis[i][j] == 0) {
                    boolean curr = dfs(i, j, grid1, grid2, delRow, delCol, n, m, vis);
                    if(curr) ans++;
                }
            }
        }

        return ans;
    }
}