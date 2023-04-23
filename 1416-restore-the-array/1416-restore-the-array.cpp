class Solution {
    int helper(string& s, int k, int i, vector<int>& dp){
        if(i == s.length()) return 1;
        if(s[i] == '0') return 0;
        if(dp[i] != -1) return dp[i];
        
        int ans = 0;
        long num = 0;

        for(int j = i; j < s.length(); j++){
            num = num * 10 + (s[j] - '0');
            if(num > k) break;
            ans += helper(s, k, j + 1, dp);
            ans %= 1000000007;
        }

        return dp[i] = ans;
    }
public:
    int numberOfArrays(string s, int k) {
        vector<int> dp(s.length() + 1, -1);
        return helper(s, k, 0, dp);
    }
};
