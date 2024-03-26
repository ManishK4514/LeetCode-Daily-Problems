class Solution {
    public void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            int j = nums[i] - 1;
            while(j >= 0 && j < n && nums[i] != nums[j]) {                
                swap(i, j, nums);
                j = nums[i] - 1;
            }
        }

        // System.out.println(Arrays.toString(nums));

        for(int i = 0; i < n; i++) {
            if(nums[i] != i + 1) return i + 1;
        }

        return n + 1;
    }
}