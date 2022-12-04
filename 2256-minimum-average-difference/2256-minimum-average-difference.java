class Solution {
    public int minimumAverageDifference(int[] nums) {
        long sum = 0, cSum = 0;
        for(int num : nums) sum += num;
        long min = Integer.MAX_VALUE;
        int n = nums.length, ans = 0;
        for(int i = 0; i < n; i++){
            cSum += nums[i];
            long avg1 = cSum/(i + 1);
            if(i == n - 1){
                if(avg1 < min){
                    return n - 1;
                }
                else{
                    break;
                }
            }
            long avg2 = (sum - cSum)/(n-i-1);
            if(min > Math.abs(avg1 - avg2)){
                min = Math.abs(avg1 - avg2);
                ans = i;
            }
        }
        return ans;
    }
}