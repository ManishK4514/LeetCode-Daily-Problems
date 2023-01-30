class Solution {
    int[] dp = new int[38];
    public int helper(int n){
        for(int i = 3; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }
    public int tribonacci(int n) {
        Arrays.fill(dp, -1);
        dp[0] = 0; dp[1] = 1; dp[2] = 1;
        return helper(n);
    }
}