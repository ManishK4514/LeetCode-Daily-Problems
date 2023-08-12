class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[] prev = new int [m];
        for(int row = 0; row < n; row++){
            int[] curr = new int[m];
            for(int col = 0; col < m; col++){
                if(obstacleGrid[row][col] == 1) curr[col] = 0;
                else if(row == 0 && col == 0) curr[col] = 1;
                else{
                    int up = 0, left = 0;
                    if(row > 0) up = prev[col];
                    if(col > 0) left = curr[col - 1];
                    curr[col] = up + left;
                }
            }
            prev = curr;
        }
        return prev[m - 1];
    }
}