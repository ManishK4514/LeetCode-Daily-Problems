class Solution {
public:    
    int helper(int n, vector<int> dp){
        for(int i = 3; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }
    int tribonacci(int n) {
        vector<int> dp (38, -1);
        dp[0] = 0; dp[1] = 1; dp[2] = 1;
        return helper(n, dp);
    }
};