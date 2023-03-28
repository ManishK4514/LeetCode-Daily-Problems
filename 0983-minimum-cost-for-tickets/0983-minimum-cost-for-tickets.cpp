class Solution {
public:
    int search(vector<int>& days, int target){
        int l = 0, r = days.size() - 1;
        while(l <= r){
            int mid = l + (r - l)/2;
            if(days[mid] >= target){
                if(mid > 0 && days[mid - 1] < target) return mid;
                r = mid - 1;
            }
            else l = mid + 1;
        }
        return days.size();
    }
    int helper(vector<int>& days, int idx, vector<int>& costs, vector<int>& dp){
        if(idx >= days.size()){
            return 0;
        }
        if(dp[idx] != -1) return dp[idx];

        int costDay = costs[0] + helper(days, idx + 1, costs, dp);
        int costWeek = costs[1] + helper(days, search(days, days[idx] + 7), costs, dp);
        int costMonth = costs[2] + helper(days, search(days, days[idx] + 30), costs, dp);
        
        dp[idx] = min(costDay, min(costWeek, costMonth));

        return dp[idx];
    }
    int mincostTickets(vector<int>& days, vector<int>& costs) {
        vector<int> dp(days.size(), -1);
        return helper(days, 0, costs, dp);
    }
};