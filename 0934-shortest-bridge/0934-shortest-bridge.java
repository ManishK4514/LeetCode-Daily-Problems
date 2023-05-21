class Touple{
    int row, col, steps;
    Touple(int row, int col, int steps){
        this.row = row;
        this.col = col;
        this.steps = steps;
    }
}

class Solution {
    public void dfs(int[][] grid, int[][] vis, int[] delRow, int[] delCol, int row, int col, int n, Queue<Touple> q){
        vis[row][col] = 1;
        q.add(new Touple(row, col, 0));

        for(int i = 0; i < 4; i++){
            int adjRow = row + delRow[i];
            int adjCol = col + delCol[i];
            
            if(adjRow >= 0 && adjRow < n && adjCol >= 0 && adjCol < n && grid[adjRow][adjCol] == 1 && vis[adjRow][adjCol] == 0){
                dfs(grid, vis, delRow, delCol, adjRow, adjCol, n, q);
            }
        }
    }

    public int shortestBridge(int[][] grid) {
        int n = grid.length;

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};
        
        int[][] vis = new int[n][n];
        for(int row = 0; row < n; row++){
            for(int col = 0; col < n; col++){
                if(grid[row][col] == 1){
                    Queue<Touple> q = new LinkedList<>();
                    dfs(grid, vis, delRow, delCol, row, col, n, q);
                    while(!q.isEmpty()){
                        int r = q.peek().row;
                        int c = q.peek().col;
                        int steps = q.peek().steps;
                        q.remove();
            
                        for(int i = 0; i < 4; i++){
                            int adjRow = r + delRow[i];
                            int adjCol = c + delCol[i];
                            int adjNodeNo = adjRow * n + adjCol;
                            if(adjRow >= 0 && adjRow < n && adjCol >= 0 && adjCol < n && grid[adjRow][adjCol] == 1 && vis[adjRow][adjCol] == 0){
                                return steps;
                            }
            
                            if(adjRow >= 0 && adjRow < n && adjCol >= 0 && adjCol < n && grid[adjRow][adjCol] == 0 && vis[adjRow][adjCol] == 0){
                                vis[adjRow][adjCol] = 1;
                                q.add(new Touple(adjRow, adjCol, steps + 1));
                            }
                            
                        }
                    }
                }
            }
        }

        return -1;
    }
}