class Solution {
public:
    int diagonalSum(vector<vector<int>>& mat) {
        int n = mat.size(), sum = 0, j = mat.size() - 1;
        for(int i = 0; i < n; i++){
            sum += mat[i][i];
            sum += mat[i][j--];
        }
        if(n % 2 != 0) sum -= mat[n/2][n/2];
        return sum;
    }
};