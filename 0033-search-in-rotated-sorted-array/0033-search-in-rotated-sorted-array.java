class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while(l <= r){
            int mid = l + (r - l)/2;

            if(nums[mid] == target) return mid;

            // not rotated
            if(nums[l] < nums[mid] && target >= nums[l] && target < nums[mid]){
                r = mid - 1;
            }
            // rotated
            else if(nums[l] > nums[mid] && (nums[mid] > target || nums[l] <= target)) r = mid - 1;
            else l = mid + 1;
        }
        return -1;
    }
}