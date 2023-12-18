class Solution {
    public int maxProductDifference(int[] nums) {        
        int n = nums.length, firstMax = -1, secondMax = -1;
        int firstMin = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
        
        for(int it : nums) {
            if(it >= firstMax) {
                secondMax = firstMax; 
                firstMax = it;
            }
            else if(it > secondMax) secondMax = it;

            if(it <= firstMin) {
                secondMin = firstMin;
                firstMin = it;
            }
            else if(it < secondMin) secondMin = it;
        }

        return firstMax * secondMax - firstMin * secondMin;
    }
}