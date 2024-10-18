class Solution {
    public int helper(int i, int[] nums, int target, int or) {
        if(i == nums.length) return or == target ? 1 : 0;

        int take = helper(i + 1, nums, target, or | nums[i]);
        int notTake = helper(i + 1, nums, target, or);

        return take + notTake;
    }
    public int countMaxOrSubsets(int[] nums) {
        int target = 0;
        for(int num : nums) target |= num;
        return helper(0, nums, target, 0);
    }
}