class Solution {
    public int helper(int n, int row, int col, int[][] moves, int rowLen, int colLen, int[][][] dp) {
        if (n == 0) return 1;
        if (dp[n][row][col] != -1) return dp[n][row][col];

        int ans = 0;
        for (int i = 0; i < moves.length; i++) {
            int nrow = row + moves[i][0];
            int ncol = col + moves[i][1];

            if ((nrow == 3 && ncol == 0) || (nrow == 3 && ncol == 2)) continue;
            if (nrow < 0 || nrow >= rowLen || ncol < 0 || ncol >= colLen) continue;

            ans += helper(n - 1, nrow, ncol, moves, rowLen, colLen, dp);
            ans %= 1000000007; 
        }

        dp[n][row][col] = ans;
        return ans;
    }

    public int knightDialer(int n) {
        int ans = 0, rowLen = 4, colLen = 3;
        int[][] moves = {
                {-2, -1}, {-2, 1},
                {-1, -2}, {-1, 2},
                {1, -2}, {1, 2},
                {2, -1}, {2, 1}
        };

        int[][][] dp = new int[n + 1][rowLen][colLen];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < rowLen; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if ((i == 3 && j == 0) || (i == 3 && j == 2)) continue;
                ans += helper(n - 1, i, j, moves, rowLen, colLen, dp);
                ans %= 1000000007; 
            }
        }

        return ans;
    }
}
