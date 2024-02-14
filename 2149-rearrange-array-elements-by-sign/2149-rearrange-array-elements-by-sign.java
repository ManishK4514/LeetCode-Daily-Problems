class Solution {
    public int[] rearrangeArray(int[] nums) {
        int i = 0, j = 1, n = nums.length;
        int[] ans = new int[n];
        for(int k = 0; k < n; k++) {
            if(nums[k] < 0) {
                ans[j] = nums[k];
                j += 2;
            }
            else {
                ans[i] = nums[k];
                i += 2;
            }
        }
        return ans;
    }
}