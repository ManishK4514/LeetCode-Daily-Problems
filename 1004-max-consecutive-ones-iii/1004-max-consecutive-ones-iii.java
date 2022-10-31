class Solution {
    public int longestOnes(int[] nums, int k) {
        int i = 0, j;
        for (j = 0; j < nums.length; j++) {
            if (nums[j] == 0) k--;
            if (k < 0 && nums[i++] == 0) k++;
        }
        return j - i;
    }
}