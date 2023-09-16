class Touple{
    int effort;
    int row;
    int col;
    
    Touple(int effort, int row, int col){
        this.effort = effort;
        this.row = row;
        this.col = col;        
    }
}
class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        
        if(n == 1 && m == 1) return 0;

        PriorityQueue<Touple> pq = new PriorityQueue<>((a, b)->{return a.effort - b.effort;});
        
        int[][] efforts = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                efforts[i][j] = (int)(1e9);
            }
        }
        
        pq.add(new Touple(0, 0, 0));
        efforts[0][0] = 0;

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};
        
        while(!pq.isEmpty()){
            int effort = pq.peek().effort;
            int row = pq.peek().row;
            int col = pq.peek().col;
            pq.remove();

            if(row == n - 1 && col == m - 1) return effort;

            for(int i = 0; i < 4; i++){
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];
                int neffort = effort;

                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m){
                    neffort = Math.max(effort, Math.abs(heights[nrow][ncol] - heights[row][col]));                    
                }

                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && efforts[nrow][ncol] > neffort){
                    efforts[nrow][ncol] = neffort;                    
                    pq.add(new Touple(neffort, nrow, ncol));
                }
            }
        }
        return 0;
    }
}