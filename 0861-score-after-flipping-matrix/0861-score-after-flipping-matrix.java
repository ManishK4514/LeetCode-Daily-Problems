class Solution {
    public void flip(int[][] grid, int j){
        for(int i = 0; i < grid.length; i++){
            if(grid[i][j] == 0) grid[i][j] = 1;
            else if(grid[i][j] == 1) grid[i][j] = 0;
        }
    }
    public int matrixScore(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for(int i = 0; i < n; i++){
            if(grid[i][0] == 0){
                for(int j = 0; j < m; j++){
                    if(grid[i][j] == 0) grid[i][j] = 1;
                    else if(grid[i][j] == 1) grid[i][j] = 0;
                }
            }
        }
        for(int j = 1; j < m; j++){
            int count0 = 0, count1 = 0;
            for(int i = 0; i < n; i++){
                if(grid[i][j] == 0) count0++;
                else count1++;
            }
            if(count0 > count1){
                flip(grid, j);
            }
        }
        int sum = 0;
        for(int i = 0; i < n; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < m; j++){
                sb.append(grid[i][j]);
            } 
            sum += Integer.parseInt(sb.toString(), 2);
        }
        return sum;
    }
}