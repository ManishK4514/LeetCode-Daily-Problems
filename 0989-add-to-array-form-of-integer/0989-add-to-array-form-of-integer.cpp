class Solution {
public:
    vector<int> addToArrayForm(vector<int>& num, int k) {
        vector<int> res;
        for(int i = num.size() - 1; i >= 0; i--){
            res.insert(res.begin(), (num[i] + k) % 10);
            k = (num[i] + k) / 10;
        }
        while (k > 0) {
            res.insert(res.begin(), k % 10);
            k /= 10;
        }
        return res;
    }
};