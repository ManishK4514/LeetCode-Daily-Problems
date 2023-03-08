class Solution {
    long findTime(int[] piles, int i){
        long time = 0;
        for(int j = 0; j < piles.length; j++){
            if(piles[j] % i != 0){
                time += (piles[j]/i) + 1;
            }
            else{
                time += piles[j]/i;
            }
        }
        return time;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < piles.length; i++){
            max = Math.max(max, piles[i]);
        }
        int start = 1;
        int end = max;
        int ans = Integer.MAX_VALUE;
        while(start <= end){
            int mid = start + (end - start)/2;
            long time = findTime(piles, mid);
            if(time <= h){
                ans = Math.min(ans, mid);
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
}