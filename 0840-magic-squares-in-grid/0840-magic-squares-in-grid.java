class Solution {
    public boolean helper(int[][] grid) {
        int rowSum = grid[0][0] + grid[0][1] + grid[0][2];

        for(int i = 0; i < 3; i++) {
            int sum = 0;
            for(int j = 0; j < 3; j++) {
                sum += grid[i][j];
            }
            if(sum != rowSum) return false;
        }

        for(int i = 0; i < 3; i++) {
            int sum = 0;
            for(int j = 0; j < 3; j++) {
                sum += grid[j][i];
            }
            if(sum != rowSum) return false;
        }

        int diagonal1 = grid[0][0] + grid[1][1] + grid[2][2];
        int diagonal2 = grid[0][2] + grid[1][1] + grid[2][0];

        if(rowSum != diagonal1) return false;
        if(rowSum != diagonal2) return false;

        return true;
    }
    public int numMagicSquaresInside(int[][] grid) {
        int n = grid.length, m = grid[0].length, ans = 0;

        for(int row = 1; row < n - 1; row++) {
            for(int col = 1; col < m - 1; col++) {
                int[][] subgrid = new int[3][3];                
                int subRow = 0;

                HashSet<Integer> set = new HashSet<>();

                boolean possible = true;

                for(int k = -1; k <= 1; k++) {                    
                    int subCol = 0;

                    for(int l = -1; l <= 1; l++) {
                        int nrow = row + k;
                        int ncol = col + l;

                        set.add(grid[nrow][ncol]);
                        if(grid[nrow][ncol] > 9 || grid[nrow][ncol] == 0) {
                            possible = false;
                            break;
                        }

                        subgrid[subRow][subCol] = grid[nrow][ncol];
                        subCol++;
                    }

                    if(!possible) break;

                    subRow++;
                }

                if(possible && set.size() == 9 && helper(subgrid)) ans++;
            }
        }

        return ans;
    }
}