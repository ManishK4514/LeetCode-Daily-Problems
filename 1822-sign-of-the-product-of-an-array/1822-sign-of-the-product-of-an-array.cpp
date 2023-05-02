class Solution {
public:
    int arraySign(vector<int>& nums) {
        int negative = 0;
        for(int it : nums) {
            if(it == 0) return 0;
            if(it < 0) negative++;
        }
        return negative % 2 == 0 ? 1 : -1;
    }
};