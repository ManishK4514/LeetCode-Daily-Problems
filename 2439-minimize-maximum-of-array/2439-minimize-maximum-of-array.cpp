class Solution {
public:
    int minimizeArrayValue(vector<int>& nums) {
        int n = nums.size();
        long long sum = 0, ans = 0;
        for(int i = 0; i < n; i++) {
            sum += nums[i];
            ans = max(ans, (sum + i) / (i + 1));
        }
        return (int) ans;
    }
};