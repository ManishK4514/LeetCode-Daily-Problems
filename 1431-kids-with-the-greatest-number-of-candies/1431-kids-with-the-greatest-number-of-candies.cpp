class Solution {
public:
    vector<bool> kidsWithCandies(vector<int>& candies, int extraCandies) {
        vector<bool> res;
        int maxi = 0;
        for(int i = 0; i < candies.size(); i++) maxi = max(maxi, candies[i]);
        for(int i = 0; i < candies.size(); i++){
            if(candies[i] + extraCandies >= maxi) res.push_back(true);
            else res.push_back(false);
        }
        return res;
    }
};