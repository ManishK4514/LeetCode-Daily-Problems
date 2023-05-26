class Solution {
    public int helper(int i, int[] piles, int m, int[][] dp){
        if(i >= piles.length) return 0;
        if(dp[i][m] != -1) return dp[i][m];
        int ans = Integer.MIN_VALUE, total = 0;
        for(int j = 0; j < 2 * m; j++){
            if(i + j < piles.length) total += piles[i + j];
            ans = Math.max(ans, total - helper(i + j + 1, piles, Math.max(m, j + 1), dp));
        }
        return dp[i][m] = ans;
    }
    public int stoneGameII(int[] piles) {
        int[][] dp = new int[piles.length][201];
        for(int[] it : dp) Arrays.fill(it, -1);
        int sum = 0;
        for(int it : piles) sum += it;
        // we are getting a - b
        int diff = helper(0, piles, 1, dp);
        // sum = a + b & diff = a - b
        // (sum + diff) -> (a + b + a - b) = 2a
        // and the answer is 2a/2 = a 
        return (sum + diff)/2;
    }
}