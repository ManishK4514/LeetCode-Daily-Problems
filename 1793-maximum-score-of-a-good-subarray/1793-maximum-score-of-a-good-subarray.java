class Solution {
    public int maximumScore(int[] nums, int k) {
        int l = k, r = k, n = nums.length, ans = nums[k], min = nums[k];

        while(l != 0 || r != n - 1) {
            if(l - 1 >= 0 && r + 1 < n) {
                if(nums[l - 1] < nums[r + 1]) min = Math.min(min, nums[++r]);
                else if(nums[l - 1] > nums[r + 1]) min = Math.min(min, nums[--l]);
                else {
                    min = Math.min(min, nums[--l]);
                    r++;
                }
            }
            else if(l - 1 >= 0) min = Math.min(min, nums[--l]);
            else if(r + 1 < n) min = Math.min(min, nums[++r]);

            ans = Math.max(ans, min * (r - l + 1));
        }

        return ans;
    }
}