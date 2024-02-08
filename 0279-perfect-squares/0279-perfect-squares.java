class Solution {
    public int helper(int i, int n, int[] dp){
        if(i == 101) {
            if(n == 0) return 0;
            return (int)1e8;
        }
        
        if(dp[n] != -1) return dp[n];

        // pick
        int pick = (int)1e9;
        if(n >= i * i) pick = 1 + helper(i, n - i * i, dp);

        // not pick
        int notPick = helper(i + 1, n, dp);

        return dp[n] = Math.min(pick, notPick);
    }
    public int numSquares(int n) {
        int[] dp = new int [10001];
        Arrays.fill(dp, -1);
        return helper(1, n, dp);
    }
}