class Solution {
public:
    bool possible(long long currTime, vector<int> time, int totalTrips){
        int n = time.size();
        long long currTrips = 0;
        for(int i = 0; i < n; i++){
            currTrips += currTime / time[i];
            if(currTrips >= totalTrips) return true;
        }
        return false;
    }
    long long minimumTime(vector<int>& time, int totalTrips) {
        long long l = 1, h = 1e14;
        while(l <= h){
            long long mid = l + (h - l)/2;
            if(possible(mid, time, totalTrips)){
                if(!possible(mid - 1, time, totalTrips)) return mid;
                h = mid - 1; 
            }
            else l = mid + 1;            
        }
        return -1;
    }
};