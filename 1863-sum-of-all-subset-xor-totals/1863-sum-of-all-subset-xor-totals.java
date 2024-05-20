class Solution {
    public int helper(int i, int[] nums, int x) {
        if(i == nums.length) return x;

        int pick = helper(i + 1, nums, x ^ nums[i]);
        int notPick = helper(i + 1, nums, x);

        return pick + notPick;
    }
    public int subsetXORSum(int[] nums) {
        return helper(0, nums, 0);
    }
}