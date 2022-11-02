class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int res = 0, i = 0, count = 0, n = nums.length;
        for (int j = 0; j < n; j++) {
            if (nums[j] % 2 == 1) {
                k--;
                count = 0;
            }
            while (k == 0) {
                k += nums[i++] & 1;
                count++;
            }
            res += count;
        }
        return res;
    }
}
