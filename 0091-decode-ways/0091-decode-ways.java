class Solution {
    public int helper(int i, String s, int[] dp) {
        if(i == s.length()) return 1;

        if(dp[i] != -1) return dp[i];

        int ans = 0;

        // take single charcter
        if(s.charAt(i) != '0') ans += helper(i + 1, s, dp);

        // take two charcter 
        if(s.charAt(i) == '1' || s.charAt(i) == '2') {
            if(i < s.length() - 1 && s.charAt(i) == '1') {
                ans += helper(i + 2, s, dp);
            }
            else if(i < s.length() - 1 && s.charAt(i + 1) <= '6') {
                ans += helper(i + 2, s, dp);
            }
        }

        return dp[i] = ans;
    }
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return helper(0, s, dp);
    }
}