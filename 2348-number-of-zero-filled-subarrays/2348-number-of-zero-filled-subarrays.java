class Solution {
public:
    long long zeroFilledSubarray(vector<int>& nums) {
        long long ans = 0, zeros = 0;
        for(int i = 0; i < nums.size(); i++){
            if(nums[i] != 0) {
                ans += zeros * (zeros + 1) / 2;
                zeros = 0;
            }
            else zeros++;
        }
        ans += zeros * (zeros + 1) / 2;
        return ans;
    }
};