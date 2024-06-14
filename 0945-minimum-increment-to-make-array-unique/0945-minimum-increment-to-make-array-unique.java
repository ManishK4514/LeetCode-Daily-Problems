class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int ans = 0, n = nums.length, prev = nums[0];
        for(int i = 1; i < n; i++) {
            if(nums[i] <= prev) {
                ans += prev + 1 - nums[i];
                nums[i] = prev + 1;
            }
            prev = nums[i];
        }
        return ans;
    }
}