class Solution {
    public int helper(int[] nums1, int[] nums2, int idx1, int idx2, int[][] dp){
        if(idx1 < 0 || idx2 < 0) return 0;
        if(dp[idx1][idx2] != -1) return dp[idx1][idx2];
        // Not take
        int a = 0 + helper(nums1, nums2, idx1 - 1, idx2, dp);
        
        // take
        int b = Integer.MIN_VALUE;
        if(nums1[idx1] == nums2[idx2]){
            int curr = 1 + helper(nums1, nums2, idx1 - 1, idx2 - 1, dp);
            b = Math.max(b, curr);
        }
        else {
            int curr = helper(nums1, nums2, idx1, idx2 - 1, dp);
            b = Math.max(b, curr);
        }

        return dp[idx1][idx2] = Math.max(a, b);
    }
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        for(int[] it : dp) Arrays.fill(it, -1);
        return helper(nums1, nums2, nums1.length - 1, nums2.length - 1, dp);
    }
}