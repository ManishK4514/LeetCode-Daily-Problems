class Solution {
public:
    bool dfs(int row, int col, vector<vector<int>>& grid){
        int n = grid.size(), m = grid[0].size();
        if(row < 0 || row >= n || col < 0 || col >= m){
            return false;
        }
        
        if(grid[row][col] == 1) return true;

        // marking visited
        grid[row][col] = 1;

        bool up = dfs(row - 1, col, grid);
        bool down = dfs(row + 1, col, grid);
        bool left = dfs(row, col - 1, grid);
        bool right = dfs(row, col + 1, grid);
        
        return up && down && left && right;
    }
    int closedIsland(vector<vector<int>>& grid) {
        int n = grid.size(), m = grid[0].size();

        int count = 0;
        for(int row = 0; row < n; row++){
            for(int col = 0; col < m; col++){
                if(grid[row][col] == 1) continue;
                
                if(dfs(row, col, grid)) count++;
            }
        }

        return count;
    }
};