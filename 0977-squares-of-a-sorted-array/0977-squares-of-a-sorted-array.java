class Solution {
    public int[] sortedSquares(int[] nums) {
        int left = 0, right = nums.length - 1;
        int[] result = new int[nums.length];
        int i = nums.length - 1, sq = 0;
        while(left <= right) {
            if(Math.abs(nums[left]) > Math.abs(nums[right])) {
                sq = nums[left];
                left++;
            } else {
                sq = nums[right];
                right--;
            }
            result[i--] = sq * sq;
        }
        return result;
    }
}