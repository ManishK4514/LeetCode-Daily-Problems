class Solution {
    public int minPairSum(int[] nums) {
        int ans = 0, n = nums.length;
        Arrays.sort(nums);
        for(int i = 0; i < n/2; i++) {
            ans = Math.max(ans, nums[i] + nums[n - i - 1]);
        }
        return ans;
    }
}