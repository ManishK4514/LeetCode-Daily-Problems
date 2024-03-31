class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int minB = -1, maxB = -1, badB = -1;
        long ans = 0, n = nums.length;
        
        for(int i = 0; i < n; i++){
            if(nums[i] == minK) minB = i;
            if(nums[i] == maxK) maxB = i;
            if(nums[i] < minK || nums[i] > maxK) badB = i;
            if(Math.min(minB, maxB) - badB > 0) ans += Math.min(minB, maxB) - badB;
        }
        return ans;
    }
}