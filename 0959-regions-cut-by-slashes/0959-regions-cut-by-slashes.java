class Pair{
    int first;
    int second;
    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public void mark(int nrow, int ncol, int[][] grid, int[][] vis, Queue<Pair> q){
        int n = grid.length;
        int m = grid[0].length;
        if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == 0 && vis[nrow][ncol] == 0){
            vis[nrow][ncol] = 1;
            q.add(new Pair(nrow, ncol));
        }
    }
    // DFS
    public void dfs(int ro, int co, int[][] grid, int[][] vis){
        vis[ro][co] = 1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(ro, co));        
        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            q.remove();
            
            // Traverse in the Neighbours and mark them if it's a land
            // up
            mark(row - 1, col, grid, vis, q);

            // down
            mark(row + 1, col, grid, vis, q);

            // left
            mark(row, col - 1, grid, vis, q);

            // right
            mark(row, col + 1, grid, vis, q);
        }
    }
    public int numIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int count = 0;
        for(int row = 0; row < n; row++){
            for(int col = 0; col < m; col++){
                if(vis[row][col] == 0 && grid[row][col] == 0){
                    dfs(row, col, grid, vis);
                    count++;
                }
            }
        }
        return count;
    }
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int[][] mat = new int[3 * n][3 * n];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].toCharArray().length; j++) {
                if (grid[i].charAt(j) == '/') {
                    mat[i * 3][j * 3 + 2] = 1;
                    mat[i * 3 + 1][j * 3 + 1] = 1;
                    mat[i * 3 + 2][j * 3] = 1;
                } else if (grid[i].charAt(j) == '\\') {
                    mat[i * 3][j * 3] = 1;
                    mat[i * 3 + 1][j * 3 + 1] = 1;
                    mat[i * 3 + 2][j * 3 + 2] = 1;
                }
            }
        }
        
        // for(int[] it : mat) System.out.println(Arrays.toString(it));
        return numIslands(mat);
    }
}