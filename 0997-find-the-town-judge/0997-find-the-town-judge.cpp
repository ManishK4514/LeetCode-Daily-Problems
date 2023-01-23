class Solution {
public:
    int findJudge(int n, vector<vector<int>>& trust) {
        vector<int> count(n + 1, 0);
        for(auto arr : trust){
            count[arr[0]]--;
            count[arr[1]]++;
        }
        for(int i = 1; i < count.size(); i++){
            if(count[i] == n - 1) return i;
        }
        return -1;
    }
};