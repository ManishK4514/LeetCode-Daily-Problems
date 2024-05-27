class Solution {
    public int binarySearch(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while(l <= r) {
            int mid = l + (r - l)/2;
            if(nums[mid] >= target) r = mid - 1;
            else l = mid + 1;
        }

        return l;
    }
    public int specialArray(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        for(int i = 0; i <= n; i++) {
            int currIndex = binarySearch(nums, i);
            int total = n - currIndex;
            if(total == i) return i;
        }
        return -1;
    }
}