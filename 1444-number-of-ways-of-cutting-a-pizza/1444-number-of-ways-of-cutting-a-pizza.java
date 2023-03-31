class Solution {
    int mod = 1_000_000_007;
    public int noOfWays(int k, int c, int row, int col, int n, int m, int[][] preSum, int[][][] dp){
        if(preSum[row][col] == 0) return 0;
        if(c == k - 1) return 1;
        
        if(dp[c][row][col] != -1) return dp[c][row][col];

        int ways = 0;

        // horizontal cuts
        for (int nrow = row + 1; nrow < n; nrow++){
            if (preSum[row][col] - preSum[nrow][col] > 0){
                ways = (ways + noOfWays(k, c + 1, nrow, col, n, m, preSum, dp)) % mod;
            }    
        }    

        // vertical cuts
        for (int ncol = col + 1; ncol < m; ncol++){
            if (preSum[row][col] - preSum[row][ncol] > 0){
                ways = (ways + noOfWays(k, c + 1, row, ncol, n, m, preSum, dp)) % mod;
            }    
        }  
        return dp[c][row][col] = ways;
    }
    public int ways(String[] pizza, int k) {
        int n = pizza.length;
        int m = pizza[0].length();
        
        int[][][] dp = new int [k][n][m];
        for(int[][] it : dp){
            for(int[] it2 : it) Arrays.fill(it2, -1);
        }

        int[][] preSum = new int[n + 1][m + 1];

        for(int row = n - 1; row >= 0; row--){
            for(int col = m - 1; col >= 0; col--){
                preSum[row][col] = preSum[row][col + 1] + preSum[row + 1][col] - preSum[row + 1][col + 1] + (pizza[row].charAt(col) == 'A' ? 1 : 0);
            }
        }

        return noOfWays(k, 0, 0, 0, n, m, preSum, dp);
    }
}