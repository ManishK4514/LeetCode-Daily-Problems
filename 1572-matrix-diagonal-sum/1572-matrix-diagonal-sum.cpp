class Solution {
public:
    int diagonalSum(vector<vector<int>>& mat) {
        int n = mat.size(), sum = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                // if-else automatically ignore the middle element of odd size matrix because that is the only position could be same and we have to take only once
                if(i == j) sum += mat[i][j];
                else if(i + j == n - 1) sum += mat[i][j];
            }
        }
        return sum;
    }
};