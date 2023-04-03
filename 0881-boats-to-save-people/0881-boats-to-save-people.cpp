class Solution {
public:
    int numRescueBoats(vector<int>& people, int limit) {
        int n = people.size();
        sort(people.begin(), people.end());
        int boat = 0;
        int l = 0, r = n - 1;
        while(l <= r){
            int currWeight = people[l] + people[r];
            if(currWeight <= limit){
                l++; r--; boat++;
            }
            else {
                r--; boat++;
            }            
        }
        return boat;
    }
};