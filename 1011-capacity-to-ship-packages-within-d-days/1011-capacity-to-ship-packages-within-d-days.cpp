class Solution {
public:
    int helper(int curr, vector<int>& weights){
        int wt = 0, n = weights.size(), countDays = 1;
        for(int i = 0; i < n; i++){
            if(weights[i] > curr){
                return -1;
            }
            wt += weights[i];
            if(wt > curr){
                countDays++;
                wt = weights[i];
            }
        }
        return countDays;
    }
    int shipWithinDays(vector<int>& weights, int days) {
        int l = 1, h = 500000;
        while(l <= h){
            int mid = l + (h - l)/2;
            int curr = helper(mid, weights);
            if(curr == -1 || curr > days) l = mid + 1;
            else h = mid - 1;
        }
        return l;
    }
};