class Solution {
    int ans;

    public void helper(int[][] grid, boolean[][] visited, int i, int j, int m, int n, int count) {
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == -1 || visited[i][j] == true) return;

        if (grid[i][j] == 2 && count == 0) {
            ans++;
        }

        count--;
        visited[i][j] = true;
        helper(grid, visited, i + 1, j, m, n, count);
        helper(grid, visited, i, j + 1, m, n, count);
        helper(grid, visited, i - 1, j, m, n, count);
        helper(grid, visited, i, j - 1, m, n, count);
        visited[i][j] = false;
        count++;
    }

    public int uniquePathsIII(int[][] grid) {
        int count = 0;
        int ii = 0, jj = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    count++;
                }
                if (grid[i][j] == 1) {
                    ii = i;
                    jj = j;
                    count++;
                }
            }
        }
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        helper(grid, visited, ii, jj, m, n, count);
        return ans;
    }
}
