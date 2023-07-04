class Solution {
    public int singleNumber(int[] nums) {
        int zeros = 0, ans = 0;
        for(int i = 0; i < 32; i++){
            zeros = 0;
            for(int j = 0; j < nums.length; j++){
                if((nums[j] & (1<<i)) == 0) zeros++;
            }
            if(zeros % 3 != 0){
                // do nothing
            }
            else ans = ans | (1 << i);
        }
        return ans;
    }
}