class Solution {
public:
    vector<vector<int>> generateMatrix(int n) {
        vector<vector<int>> matrix (n, vector<int>(n, 0));
        int top = 0, right = n - 1, bottom = n - 1, left = 0, dir = 0, curr = 1;
        while(top <= bottom && left <= right){
            if(dir == 0){
                for(int i = left; i <= right; i++){
                    matrix[top][i] = curr++;                    
                }
                top++;
            }
            else if(dir == 1){
                for(int i = top; i <= bottom; i++){
                    matrix[i][right] = curr++;
                }
                right--; 
            }
            else if(dir == 2){
                for(int i = right; i >= left; i--){
                    matrix[bottom][i] = curr++;
                }
                bottom--;
            }
            else{
                for(int i = bottom; i >= top; i--){
                    matrix[i][left] = curr++;
                }
                left++; 
            }
            dir = (dir + 1) % 4;
        }
        return matrix;
    }
};