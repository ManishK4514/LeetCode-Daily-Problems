class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[2*n];
        int j = 0;
        for(int i = 0; i < nums.length; i+=2){
            res[i] = nums[j++];
        }
        for(int i = 1; i < nums.length; i+=2){
            res[i] = nums[j++];
        }
        return res;
    }
}