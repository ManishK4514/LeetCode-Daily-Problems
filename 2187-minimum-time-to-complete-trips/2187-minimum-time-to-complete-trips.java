class Solution {
    public boolean possible(long currTime, int[] time, int totalTrips){
        int n = time.length;
        long currTrips = 0;
        for(int i = 0; i < n; i++){
            currTrips += currTime / time[i];
            if(currTrips >= totalTrips) return true;
        }
        return false;
    }
    public long minimumTime(int[] time, int totalTrips) {
        long l = 1, h = Long.MAX_VALUE;
        while(l <= h){
            long mid = l + (h - l)/2;
            if(possible(mid, time, totalTrips)){
                if(!possible(mid - 1, time, totalTrips)) return mid;
                h = mid - 1; 
            }
            else l = mid + 1;            
        }
        return -1;
    }
}