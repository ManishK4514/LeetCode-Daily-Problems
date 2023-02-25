class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int profit = 0, currMin = INT_MAX, n = prices.size();
        for(int i = 0; i < n; i++){
            currMin = min(prices[i], currMin);
            profit = max(profit, prices[i] - currMin);
        }
        return profit;
    }
};