class Solution {
    public int helper(int i, String s, int takingBOnly, int[][] dp) {
        if(i == s.length()) return 0;

        if(dp[i][takingBOnly] != -1) return dp[i][takingBOnly];

        int ans = (int)(1e9);

        // delete
        ans = Math.min(ans, 1 + helper(i + 1, s, takingBOnly, dp));

        // not delete
        if(s.charAt(i) == 'a' && takingBOnly == 0) {
            ans = Math.min(ans, helper(i + 1, s, takingBOnly, dp));
        }
        else if(s.charAt(i) == 'b') {
            ans = Math.min(ans, helper(i + 1, s, 1, dp));            
        }

        return dp[i][takingBOnly] = ans;
    }
    public int minimumDeletions(String s) {
        int n = s.length();
        int[][] dp = new int[n][2];
        for(int[] it : dp) Arrays.fill(it, -1);
        return helper(0, s, 0, dp);
    }
}