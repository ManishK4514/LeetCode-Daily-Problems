class Solution {
    public int helper(int[] nums, int diff, int curr, int[][] dp){
        if(curr == nums.length) return 0;

        if(dp[curr][diff + 501] != -1) return dp[curr][diff + 501];
        
        int max = 1;

        // pick 
        for(int i = curr + 1; i < nums.length; i++){
            if(nums[i] - nums[curr] == diff){
                max = Math.max(max, 1 + helper(nums, diff, i, dp));
            }
        }
        
        return dp[curr][diff + 501] = max;
    }
    
    public int longestArithSeqLength(int[] nums) {
        int ans = 1, n = nums.length;
        int[][] dp = new int[1001][1003];
        for(int[] it : dp) Arrays.fill(it, -1);
        
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                int curr = 1 + helper(nums, nums[j] - nums[i], j, dp);
                ans = Math.max(curr, ans);
            }            
        }
        
        return ans;
    }
}
