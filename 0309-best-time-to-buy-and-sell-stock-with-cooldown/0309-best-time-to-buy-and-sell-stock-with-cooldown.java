class Solution {
    public int helper(int idx, int buy, int[] prices, int[][] dp){
        if(idx >= prices.length) return 0;
        if(dp[idx][buy] != -1) return dp[idx][buy];
        if(buy == 1){
            return dp[idx][buy] = Math.max(-prices[idx] + helper(idx + 1, 0, prices, dp), 
                    0 + helper(idx + 1, 1, prices, dp));
        }
        return dp[idx][buy] = Math.max(prices[idx] + helper(idx + 2, 1, prices, dp), 
                    0 + helper(idx + 1, 0, prices, dp));
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int[] num : dp){
            Arrays.fill(num, -1);
        }
        return helper(0, 1, prices, dp);
    }
}