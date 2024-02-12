class Solution {
    public int majorityElement(int[] nums) {
        int element = nums[0], freq = 1, n = nums.length;

        for(int i = 1; i < n; i++) {
            if(nums[i] == element) freq++;
            else {
                freq--;
                if(freq < 0) {
                    freq = 0;
                    element = nums[i];
                }
            }
        }

        return element;
    }
}