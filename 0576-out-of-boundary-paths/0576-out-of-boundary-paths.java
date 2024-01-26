class Solution {
    public long helper(int row, int col, int m, int n, int[] delRow, int[] delCol, int maxMove, long[][][] dp, int mod) {
        if (row < 0 || row >= m || col < 0 || col >= n) return 1;

        if (maxMove == 0) return 0;

        if (dp[row][col][maxMove] != -1) {
            return dp[row][col][maxMove];
        }

        long ans = 0;

        for (int i = 0; i < 4; i++) {
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];

            ans = (ans + helper(nrow, ncol, m, n, delRow, delCol, maxMove - 1, dp, mod)) % mod;
        }

        dp[row][col][maxMove] = ans;
        return ans;
    }

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[] delRow = {-1, 1, 0, 0};
        int[] delCol = {0, 0, -1, 1};
        int mod = 1000000007;

        long[][][] dp = new long[m][n][maxMove + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return (int) helper(startRow, startColumn, m, n, delRow, delCol, maxMove, dp, mod);
    }
}
