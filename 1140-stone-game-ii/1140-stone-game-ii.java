class Solution {
    public int helper(int i, int[] piles, int m, int[][] dp) {
        if(i >= piles.length) return 0;

        if(dp[i][m] != -1) return dp[i][m];
        
        int alice = 0, aliceMinusBob = Integer.MIN_VALUE;
        for(int x = 0; x < 2 * m; x++) {
            if(i + x < piles.length) alice += piles[i + x];

            aliceMinusBob = Math.max(aliceMinusBob, alice - helper(i + x + 1, piles, Math.max(m, x + 1), dp));
        }

        return dp[i][m] = aliceMinusBob;
    }
    public int stoneGameII(int[] piles) {
        int alicePlusBob = 0, n = piles.length;
        for(int pile : piles) alicePlusBob += pile;

        int[][] dp = new int[n][201];
        for(int[] it : dp) Arrays.fill(it, -1);
        int aliceMinusBob = helper(0, piles, 1, dp);

        return (alicePlusBob + aliceMinusBob)/2;
    }
}