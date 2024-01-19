class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int ans = Integer.MAX_VALUE;
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == 0) dp[i][j] = matrix[i][j];
                else{
                    int opt1 = Integer.MAX_VALUE, opt2 = Integer.MAX_VALUE, opt3 = Integer.MAX_VALUE;
                    if(i - 1 >= 0 && j - 1 >= 0) opt1 = dp[i - 1][j - 1];
                    if(i - 1 >= 0) opt2 = dp[i - 1][j];
                    if(i - 1 >= 0 && j + 1 < n) opt3 = dp[i - 1][j + 1];
            
                    dp[i][j] = matrix[i][j] + Math.min(opt1, Math.min(opt2, opt3));
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int j = 0; j < n; j++){
            min = Math.min(min, dp[n - 1][j]);
        }
        return min;
    }
}