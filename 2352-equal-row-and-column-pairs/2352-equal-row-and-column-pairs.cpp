class Solution {
public:
    int equalPairs(vector<vector<int>>& grid) {
        int count = 0, n = grid.size();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                bool flag = true;
                for(int k = 0; k < n; k++){
                    if(grid[i][k] != grid[k][j]){
                        flag = false; break;
                    }
                }
                if(flag) count++;
            }
        }
        return count;
    }
};