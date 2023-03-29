class Solution {
public:
    int helper(vector<int>& satisfaction, int idx, int count, vector<vector<int>>& dp){
        if(idx >= satisfaction.size()) return 0;

        if(dp[idx][count] != -1) return dp[idx][count];

        // pick
        int a = (satisfaction[idx] * count) + helper(satisfaction, idx + 1, count + 1, dp);

        // not pick
        int b = 0 + helper(satisfaction, idx + 1, count, dp);

        return dp[idx][count] = max(a, b);
    }
    int maxSatisfaction(vector<int>& satisfaction) {
        int n = satisfaction.size();
        vector<vector<int>> dp (n + 1, vector<int>(n + 1, -1));
        sort(satisfaction.begin(), satisfaction.end());
        return helper(satisfaction, 0, 1, dp);
    }
};