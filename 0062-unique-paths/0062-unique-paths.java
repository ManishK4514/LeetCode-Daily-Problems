class Solution {
    public int uniquePaths(int m, int n) {
        int[] prev = new int[n];
        for(int row = 0; row < m; row++){
            int[] curr = new int[n];
            for(int col = 0; col < n; col++){
                if(row == 0 && col == 0) curr[col] = 1;
                else{
                    int up = 0, left = 0;
                    if(row > 0) up = prev[col];
                    if(col > 0) left = curr[col - 1];
                            
                    curr[col] = left + up;
                }
            }
            prev = curr;
        }
        return prev[n - 1];
    }
}