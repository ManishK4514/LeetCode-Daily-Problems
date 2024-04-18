class Solution {
    public int islandPerimeter(int[][] grid) {
        int count = 0, n = grid.length, m = grid[0].length;
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        for(int row = 0; row < n; row++) {
            for(int col = 0; col < m; col++) {
                if(grid[row][col] == 1) {
                    for(int i = 0; i < 4; i++) {
                        int nrow = row + delRow[i];
                        int ncol = col + delCol[i];

                        if(nrow < 0 || nrow >= n || ncol < 0 || ncol >= m) count++;
                        else if(grid[nrow][ncol] == 0) count++;
                    }
                }
            }
        }

        return count;
    }
}