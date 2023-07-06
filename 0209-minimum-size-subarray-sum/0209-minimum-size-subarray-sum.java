class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0, r = 0, n = nums.length, sum = 0, ans = Integer.MAX_VALUE;
        while(r < n){
            sum += nums[r];            
            while(sum >= target){
                ans = Math.min(ans, r - l + 1);
                sum -= nums[l++];
            }            
            r++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}