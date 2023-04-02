class Solution {
public:
    vector<int> successfulPairs(vector<int>& spells, vector<int>& potions, long long success) {
        int n = spells.size();
        int m = potions.size();
        vector<int> res(n);
        sort(potions.begin(), potions.end());
        for(int i = 0; i < n; i++){
            int l = 0, r = m - 1;
            while(l <= r){
                int mid = l + (r - l)/2;
                long product = (long) spells[i] * potions[mid];
                if(product >= success){
                    r = mid - 1;
                }
                else l = mid + 1;
            }
            res[i] = m - l;
        }
        return res;
    }
};