class Solution {
    public void helper(int prow, int pcol, int[][] grid, int[][] vis, int m, int n){
        vis[prow][pcol] = 1;

        // up
        int row = prow - 1;
        int col = pcol;
        while(row >= 0){
            if(grid[row][col] == 1 || grid[row][col] == 2) break;
            vis[row--][col] = 1;
        }

        // down
        row = prow + 1;
        col = pcol;
        while(row < m){
            if(grid[row][col] == 1 || grid[row][col] == 2) break;
            vis[row++][col] = 1;
        }

        // left
        row = prow;
        col = pcol - 1;
        while(col >= 0){
            if(grid[row][col] == 1 || grid[row][col] == 2) break;
            vis[row][col--] = 1;
        }

        // right
        row = prow;
        col = pcol + 1;
        while(col < n){
            if(grid[row][col] == 1 || grid[row][col] == 2) break;
            vis[row][col++] = 1;
        }
    }
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];
        for(int[] guard : guards){
            grid[guard[0]][guard[1]] = 1;
        }
        for(int[] wall : walls){
            grid[wall[0]][wall[1]] = 2;
        }
        int[][] vis = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2) vis[i][j] = 1;
                else if(grid[i][j] == 1){
                    helper(i, j, grid, vis, m, n);
                }
            }
        }
        int count = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(vis[i][j] == 0) count++;
            }
        }
        return count;
    }
}