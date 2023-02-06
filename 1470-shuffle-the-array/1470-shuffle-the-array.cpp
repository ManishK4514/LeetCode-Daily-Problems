class Solution {
public:
    vector<int> shuffle(vector<int>& nums, int n) {
        for(int i = 0; i < n; i++){
            nums[i + n] += nums[i] * 10000;
        }
        for(int i = 0; i < n; i++){
            nums[2 * i] = nums[i + n]/10000;
            nums[(2 * i) + 1] = nums[i + n] % 10000;
        }
        return nums;
    }
};