class Solution {
    public int longestSubarray(int[] nums) {
        int length = 0, max = 0;
        for(int i=0; i<nums.length; i++) max = Math.max(max,nums[i]);

        int count=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==max){
                count++;
                length = Math.max(length,count);
            }
            else count = 0;
        }
        return length;
    }
}