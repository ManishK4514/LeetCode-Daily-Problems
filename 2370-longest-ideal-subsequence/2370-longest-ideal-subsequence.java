class Solution {
    public int helper(String s, int i, int lastChar, int k, int[][] dp) {
        if(i == s.length()) return 0;

        if(dp[i][lastChar + 1] != -1) return dp[i][lastChar + 1];

        int ans = 0;
        
        // take
        if(lastChar == -1) {
            ans = Math.max(ans, 1 + helper(s, i + 1, s.charAt(i) - 'a', k, dp));
        }
        else if(Math.abs((s.charAt(i) - 'a') - lastChar) <= k){
            ans = Math.max(ans, 1 + helper(s, i + 1, s.charAt(i) - 'a', k, dp));
        }
        
        // don't take
        ans = Math.max(ans, helper(s, i + 1, lastChar, k, dp));

        return dp[i][lastChar + 1] = ans;
    }
    public int longestIdealString(String s, int k) {
        int n = s.length();
        int[][] dp = new int[n][27];
        for(int[] it : dp) Arrays.fill(it, -1);
        return helper(s, 0, -1, k, dp);
    }
}