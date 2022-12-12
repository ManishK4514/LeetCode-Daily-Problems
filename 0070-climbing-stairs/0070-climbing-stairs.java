class Solution {
    public int count(int n, int steps, int[] dp){
        if(steps > n) return 0;
        if(steps == n) return 1;
        if(dp[steps] != -1){
            return dp[steps];
        }
        dp[steps] = count(n, steps + 1, dp) + count(n, steps + 2, dp);
        return dp[steps];
    }
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return count(n, 0, dp);
    }
}