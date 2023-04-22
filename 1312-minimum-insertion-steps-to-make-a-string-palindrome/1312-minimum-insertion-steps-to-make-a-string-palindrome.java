class Solution {
    public int longestPalindromicSubseq(String s) {
        int n = s.length();
        int[] dp = new int[n];
        int[] dpPrev = new int[n];

        for (int start = n - 1; start >= 0; --start) {
            dp[start] = 1;
            for (int end = start + 1; end < n; ++end) {
                if (s.charAt(start) == s.charAt(end)) {
                    dp[end] = dpPrev[end - 1] + 2;
                } else {
                    dp[end] = Math.max(dpPrev[end], dp[end - 1]);
                }
            }
            dpPrev = dp.clone();
        }

        return dp[n - 1];
    }

    public int minInsertions(String s) {
        return s.length() - longestPalindromicSubseq(s);
    }
}