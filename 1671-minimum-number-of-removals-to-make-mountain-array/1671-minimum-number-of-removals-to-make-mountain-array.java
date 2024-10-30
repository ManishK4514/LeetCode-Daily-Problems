class Solution {
    public int helper(int i, int prevIdx, int peakTaken, int[] nums, int[][][] dp, int afterPeak) {
        if(i == nums.length) {
            if(afterPeak == 0) return (int)(1e9);
            return 0;
        }

        if(dp[i][prevIdx + 1][peakTaken] != -1) return dp[i][prevIdx + 1][peakTaken];

        int ans = (int)(1e9);

        // take it as peak
        if(prevIdx != -1 && peakTaken == 0 && nums[i] > nums[prevIdx]) {
            ans = Math.min(ans, helper(i + 1, i, 1, nums, dp, afterPeak));
        }
        
        // take it as slope
        if(prevIdx == -1 || (peakTaken == 0 && nums[i] > nums[prevIdx]) || (peakTaken == 1 && nums[i] < nums[prevIdx])) {
            ans = Math.min(ans, helper(i + 1, i, peakTaken, nums, dp, (peakTaken == 1 && nums[i] < nums[prevIdx]) ? 1 : afterPeak));
        }

        // notTake
        ans = Math.min(ans, 1 + helper(i + 1, prevIdx, peakTaken, nums, dp, afterPeak));

        return dp[i][prevIdx + 1][peakTaken] = ans;
    }
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int[][][] dp = new int[n][n + 1][2];
        for(int[][] it : dp) {
            for(int[] it2 : it) {
                Arrays.fill(it2, -1);
            }
        }
        return helper(0, -1, 0, nums, dp, 0);
    }
}