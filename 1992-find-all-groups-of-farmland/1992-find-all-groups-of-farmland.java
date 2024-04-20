class Solution {
    int rightRow = -1, rightCol = -1;
    public void dfs(int[][] land, int row, int col, int[] delRow, int[] delCol) {
        int n = land.length, m = land[0].length;

        rightRow = Math.max(rightRow, row);
        rightCol = Math.max(rightCol, col);
        
        for(int i = 0; i < 4; i++) {
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];

            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && land[nrow][ncol] == 1){
                land[nrow][ncol] = 0;
                dfs(land, nrow, ncol, delRow, delCol);
            }
        }
    }
    public int[][] findFarmland(int[][] land) {
        int n = land.length, m = land[0].length;

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        List<int[]> ans = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(land[i][j] == 1) {
                    rightRow = i; rightCol = j;
                    dfs(land, i, j, delRow, delCol);
                    ans.add(new int[]{i, j, rightRow, rightCol});
                }
            }
        }

        int[][] result = new int[ans.size()][4];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }
    
        return result;
    }
}