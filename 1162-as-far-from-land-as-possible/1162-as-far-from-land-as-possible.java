class Touple{
    int row;
    int col;
    int steps;
    Touple(int row, int col, int steps){
        this.row = row;
        this.col = col;
        this.steps = steps;
    }
}

class Solution {
    public int maxDistance(int[][] grid) {
        int ans = -1;

        int n = grid.length;
        int m = grid[0].length;

        int[][] vis = new int[n][m];
        int[][] dist = new int[n][m];

        Queue<Touple> q = new LinkedList<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    q.add(new Touple(i, j, 0));
                    vis[i][j] = 1;
                }
            }
        }
        
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        while(!q.isEmpty()){
            int row = q.peek().row;
            int col = q.peek().col;
            int steps = q.peek().steps;

            if(grid[row][col] == 0) ans = Math.max(steps, ans);

            q.remove();
            for(int i = 0; i < 4; i++){
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];
                
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0){
                    vis[nrow][ncol] = 1;
                    q.add(new Touple(nrow, ncol, steps + 1));
                }
            }
        }
        return ans;
    }
}