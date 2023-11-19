class Solution {
    public int reductionOperations(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, min = nums[0], count = 0;
        for(int i = 1; i < n; i++) {
            if(nums[i] != min) {
                count += n - i;
                min = nums[i];
            }
        }
        return count;
    }
}