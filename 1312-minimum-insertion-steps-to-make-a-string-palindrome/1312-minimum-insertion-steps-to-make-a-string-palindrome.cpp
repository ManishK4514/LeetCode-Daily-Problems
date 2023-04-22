class Solution {
public:
    int longestPalindromicSubseq(string s) {
        int n = s.length();
        vector<int> dp (n, 0);
        vector<int> dpPrev (n, 0);

        for (int start = n - 1; start >= 0; --start) {
            dp[start] = 1;
            for (int end = start + 1; end < n; ++end) {
                if (s[start] == s[end]) {
                    dp[end] = dpPrev[end - 1] + 2;
                } else {
                    dp[end] = max(dpPrev[end], dp[end - 1]);
                }
            }
            dpPrev = dp;
        }

        return dp[n - 1];
    }

    int minInsertions(string s) {
        return s.length() - longestPalindromicSubseq(s);
    }
};