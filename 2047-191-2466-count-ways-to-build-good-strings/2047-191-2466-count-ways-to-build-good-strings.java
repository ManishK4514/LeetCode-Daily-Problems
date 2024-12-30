class Solution {
    public int helper(int low, int high, int zero, int one, int len, int[] dp) {
        if(len > high) return 0;
        if(dp[len] != -1) return dp[len];

        int ans = 0;
        ans = (ans + helper(low, high, zero, one, len + zero, dp)) % ((int)(1e9 + 7));
        ans = (ans + helper(low, high, zero, one, len + one, dp)) % ((int)(1e9 + 7));

        return dp[len] = (len >= low && len <= high ? ans + 1 : ans) % ((int)(1e9 + 7));
    }

    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp = new int[(int)(1e5 + 1)];
        Arrays.fill(dp, -1);
        return helper(low, high, zero, one, 0, dp);
    }
}