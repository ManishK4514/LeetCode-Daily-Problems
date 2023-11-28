class Solution {
    public int helper(int i, String corridor, int seat, int[][] dp) {
        if(i == corridor.length()) {
            if(seat == 2) return 1;
            return 0;
        }

        if(dp[i][seat] != -1) return dp[i][seat];

        int ans = 0, mod = (int)(1e9 + 7);

        // Partition
        if(seat == 2) {
            if(corridor.charAt(i) == 'P') {
                ans = (ans + helper(i + 1, corridor, 0, dp)) % mod;
            }
            else ans = (ans + helper(i + 1, corridor, 1, dp)) % mod;
        }

        // Do not Partition
        if(seat <= 1) {
            ans = (ans + helper(i + 1, corridor, seat + (corridor.charAt(i) == 'S' ? 1 : 0), dp)) % mod;
        }
        else if(seat == 2 && corridor.charAt(i) == 'P') {
            ans = (ans + helper(i + 1, corridor, seat, dp)) % mod;
        }

        return dp[i][seat] = ans % mod;
    }
    public int numberOfWays(String corridor) {
        int n = corridor.length();
        int[][] dp = new int[n][3];
        for(int[] it : dp) Arrays.fill(it, -1);
        return helper(0, corridor, 0, dp);
    }
}