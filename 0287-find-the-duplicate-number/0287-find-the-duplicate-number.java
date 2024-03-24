class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            int idx = nums[i] - 1;
            while(nums[i] != nums[idx]) {                
                int temp = nums[i];
                nums[i] = nums[idx];
                nums[idx] = temp;
                idx = nums[i] - 1;
            }
            if(idx != i) return nums[i];
        }

        return -1;
    }
}