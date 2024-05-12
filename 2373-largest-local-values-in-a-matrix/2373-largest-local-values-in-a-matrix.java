class Solution {
    public int maxValue(int row, int col, int[][] grid) {
        int max = Integer.MIN_VALUE;
        for(int i = -1; i <= 1; i++) {
            for(int j = -1; j <= 1; j++) {
                int nrow = row + i;
                int ncol = col + j;

                max = Math.max(max, grid[nrow][ncol]);
            }
        }

        return max;
    }
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] ans = new int[n - 2][n - 2];

        for(int i = 1; i < n - 1; i++) {
            for(int j = 1; j < n - 1; j++) {
                ans[i - 1][j - 1] = maxValue(i, j, grid);
            }
        }

        return ans;
    }
}