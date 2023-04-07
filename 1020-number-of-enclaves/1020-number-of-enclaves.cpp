class Solution {
public:
    int count = 0;
    bool dfs(int row, int col, vector<vector<int>>& grid, int n, int m){
        if(row < 0 || row >= n || col < 0 || col >= m) return false;

        if(grid[row][col] == 0) return true;

        // marking visited
        grid[row][col] = 0;
        count++;

        bool up = dfs(row - 1, col, grid, n, m);
        bool down = dfs(row + 1, col, grid, n, m);
        bool left = dfs(row, col - 1, grid, n, m);
        bool right = dfs(row, col + 1, grid, n, m);

        return up && down && left && right;
    }
    int numEnclaves(vector<vector<int>>& grid) {
        int n = grid.size();
        int m = grid[0].size();
        
        int ans = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 0) continue;
                count = 0;
                // System.out.println(i + " " + j);
                if(dfs(i, j, grid, n, m)) ans += count;
            }
        }

        return ans;
    }
};