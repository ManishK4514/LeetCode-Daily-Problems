class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int l = 0, r = nums.length - 1;
        while(l < r) {
            if(nums[l] % 2 == 0) l++;
            else if(nums[r] % 2 != 0) r--;
            else {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                l++; r--;
            }
        }

        return nums;
    }
}