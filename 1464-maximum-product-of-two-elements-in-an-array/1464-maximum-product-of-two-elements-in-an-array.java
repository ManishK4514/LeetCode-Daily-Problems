class Solution {
    public int maxProduct(int[] nums) {
        int max = -1, secondMax = -1;
        for(int it : nums) {
            if(max <= it) {
                secondMax = max;
                max = it;
            }
            else secondMax = Math.max(secondMax, it);
        }
        return (max - 1) * (secondMax - 1);
    }
}