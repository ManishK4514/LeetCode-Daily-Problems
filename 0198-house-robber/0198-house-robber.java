class Solution {
    public int maxAmount(int[] nums, int i, int[] dp){
        if(i >= nums.length){
            return 0;
        }
        
        if(dp[i] != -1) return dp[i];

        // pick
        int pick = maxAmount(nums, i + 2, dp) + nums[i];

        // not pick
        int notPick =  maxAmount(nums, i + 1, dp);
        dp[i] =  Math.max(pick, notPick);
        return dp[i];
    }
    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp, -1);
        return maxAmount(nums, 0, dp);
    }
}