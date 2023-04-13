class Solution {
public:
    bool validateStackSequences(vector<int>& pushed, vector<int>& popped) {
        int i = 0, j = 0;
        for(auto it : pushed){
            pushed[i++] = it;
            while(i > 0 && pushed[i - 1] == popped[j]){
                i--; j++;
            }
        }
        return i == 0 ? true : false;
    }
};