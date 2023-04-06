class Pair{
    int row;
    int col;
    Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public boolean dfs(int row, int col, int[][] grid){
        int n = grid.length, m = grid[0].length;
        if(row < 0 || row >= n || col < 0 || col >= m){
            return false;
        }
        
        if(grid[row][col] == 1) return true;

        // marking visited
        grid[row][col] = 1;

        boolean up = dfs(row - 1, col, grid);
        boolean down = dfs(row + 1, col, grid);
        boolean left = dfs(row, col - 1, grid);
        boolean right = dfs(row, col + 1, grid);
        
        return up && down && left && right;
    }
    public int closedIsland(int[][] grid) {
        int n = grid.length, m = grid[0].length;

        int count = 0;
        for(int row = 0; row < n; row++){
            for(int col = 0; col < m; col++){
                if(grid[row][col] == 1) continue;
                
                if(dfs(row, col, grid)) count++;
            }
        }

        return count;
    }
}