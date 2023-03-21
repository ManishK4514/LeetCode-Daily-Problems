class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long ans = 0, zeros = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0) {
                ans += zeros * (zeros + 1) / 2;
                zeros = 0;
            }
            else zeros++;
        }
        ans += zeros * (zeros + 1) / 2;
        return ans;
    }
}