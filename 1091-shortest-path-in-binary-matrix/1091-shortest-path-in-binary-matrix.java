// Adding to github
class Touple{
    int row;
    int col;
    int dis;
    Touple(int row, int col, int dis){
        this.row = row;
        this.col = col;
        this.dis = dis;
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] != 0) return -1;
        else if(grid[0][0] == 0 && grid.length == 1) return 1;

        int n = grid.length;
        
        Queue<Touple> q = new LinkedList<>();
        int[][] dist = new int[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                dist[i][j] = (int)(1e9);
            }
        }

        dist[0][0] = 1;

        q.add(new Touple(0, 0, 1));

        int[] delRow = {0, 0, 1, -1, 1, -1, -1, 1};
        int[] delCol = {1, -1, 0, 0, -1, 1, -1, 1};

        while(!q.isEmpty()){
            int row = q.peek().row;
            int col = q.peek().col;
            int dis = q.peek().dis;
            q.remove();
                                  
            for(int i = 0; i < 8; i++){
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];                
                
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < n && dist[nrow][ncol] > dis + 1 && grid[nrow][ncol] == 0){
                    dist[nrow][ncol] = dis + 1;
                    if(nrow == n - 1 && ncol == n - 1) return dis + 1;
                    q.add(new Touple(nrow, ncol, dis + 1));
                }
            }
        }
        return -1;
    }
}