class Solution {
public:
    long long findTime(vector<int>& piles, int i){
        long long time = 0;
        for(int j = 0; j < piles.size(); j++){
            if(piles[j] % i != 0){
                time += (piles[j]/i) + 1;
            }
            else{
                time += piles[j]/i;
            }
        }
        return time;
    }
    int minEatingSpeed(vector<int>& piles, int h) {
        int maxi = INT_MIN;
        for(int i = 0; i < piles.size(); i++){
            maxi = max(maxi, piles[i]);
        }
        int start = 1;
        int end = maxi;
        int ans = INT_MAX;
        while(start <= end){
            int mid = start + (end - start)/2;
            long long time = findTime(piles, mid);
            if(time <= h){
                ans = min(ans, mid);
                end = mid - 1;
            }
            else if(time > h){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        
        return ans;
    }
};