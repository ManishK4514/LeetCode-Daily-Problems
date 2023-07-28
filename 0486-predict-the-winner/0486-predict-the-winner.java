// https://www.youtube.com/watch?v=ww4V7vRIzSk

class Solution {
    public int helper(int i, int j, int[] nums) {
        // base case
        if(i > j) return 0;
        
        // choose ith (take the Worst when you are getting)
        int a = nums[i] + Math.min(helper(i + 2, j, nums), helper(i + 1, j - 1, nums)); 

        // choose jth (take the Worst when you are getting)
        int b = nums[j] + Math.min(helper(i, j - 2, nums), helper(i + 1, j - 1, nums));
        
        // choose the best if you are choosing
        return Math.max(a, b);
    }

    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length, totalSum = 0;
        for(int it : nums) totalSum += it;

        int firstPlayer = helper(0, n - 1, nums);
        int secondPlayer = totalSum - firstPlayer;
        return firstPlayer >= secondPlayer;
    }
}