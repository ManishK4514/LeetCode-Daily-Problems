class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int i = 0, j = 0, ans = Integer.MAX_VALUE, n = nums1.length, m = nums2.length;
        while(i < n && j < m) {
            if(nums1[i] == nums2[j]) {
                ans = Math.min(ans, nums1[i]);
                i++; j++;
            }
            else if(nums1[i] < nums2[j]) i++;
            else j++;
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}