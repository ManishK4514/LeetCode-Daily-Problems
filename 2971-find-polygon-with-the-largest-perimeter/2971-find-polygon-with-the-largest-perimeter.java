class Solution {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        long sum = nums[0] + nums[1], ans = -1;
        
        for(int i = 2; i < n; i++) {
            if(nums[i] >= sum) sum += nums[i];
            else ans = sum = sum + nums[i];
        }
        
        return ans;        
    }
}