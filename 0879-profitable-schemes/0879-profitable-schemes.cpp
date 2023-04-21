class Solution {
    int mod = (int)(1e9 + 7);
public:
    int helper(vector<int>& profit, vector<int>& group, int minProfit, int idx, int n, int m, int cost, int members, vector<vector<vector<int>>>& dp) {
        if (idx == m) {
            if (cost >= minProfit && members <= n) return 1;
            return 0;
        }
        else if (n < members) return 0;
        if (dp[idx][cost][members] != -1) return dp[idx][cost][members];
        // pick
        int a = helper(profit, group, minProfit, idx + 1, n, m, min(cost + profit[idx], minProfit), members + group[idx], dp);
        // not pick
        int b = helper(profit, group, minProfit, idx + 1, n, m, cost, members, dp);
        return dp[idx][cost][members] = ((a) % mod + (b) % mod) % mod;
    }
    int profitableSchemes(int n, int minProfit, vector<int>& group, vector<int>& profit) {
        int m = profit.size();
        vector<vector<vector<int>>> dp(m + 1, vector<vector<int>>(minProfit + 1, vector<int>(n + 1, -1)));
        return helper(profit, group, minProfit, 0, n, m, 0, 0, dp) % mod;
    }
};
