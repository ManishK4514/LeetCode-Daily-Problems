class Solution {
public:
    int helper(vector<vector<int>>& grid, int row, int col, int n, int m, vector<vector<int>>& dp){
        // base case
        if(row < 0 || row >= n || col < 0 || col >= m) return INT_MAX;

        if(dp[row][col] != -1) return dp[row][col];

        if(row == n - 1 && col == m - 1) return dp[row][col] = grid[row][col];

        int down = helper(grid, row + 1, col, n, m, dp);
        int right = helper(grid, row, col + 1, n, m, dp);

        return dp[row][col] = grid[row][col] + min(right, down);
    }
    int minPathSum(vector<vector<int>>& grid) {
        int n = grid.size();
        int m = grid[0].size();
        vector<vector<int>> dp(n, vector<int>(m, -1));
        return helper(grid, 0, 0, n, m, dp);
    }
};