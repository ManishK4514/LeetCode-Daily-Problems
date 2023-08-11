class Solution {
    public int helper(int i, int amt, int[] coins, int[][] dp){
        if(i < 0) {
            if(amt == 0) return 1;
            return 0;
        }

        if(dp[i][amt] != -1) return dp[i][amt];

        int a = 0;
        if(amt >= coins[i]) {
            a = helper(i, amt - coins[i], coins, dp);
        }

        int b = helper(i - 1, amt, coins, dp);

        return dp[i][amt] = a + b;
    }
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for(int[] it : dp) Arrays.fill(it, -1);
        return helper(n - 1, amount, coins, dp);
    }
}