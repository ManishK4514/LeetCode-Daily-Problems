class Solution {
    public int minDifference(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, min = Integer.MAX_VALUE, j = n - 4;
        if(n <= 4) return 0;
        
        for(int i = 0; i <= 3; i++, j++) {
            min = Math.min(min, nums[j] - nums[i]);
        }

        return min;
    }
}