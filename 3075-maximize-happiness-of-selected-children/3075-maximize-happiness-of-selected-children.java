class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        long ans = 0, decrement = 0;        
        Arrays.sort(happiness);
        
        for(int i = happiness.length - 1; i >= 0; i--) {
            ans += Math.max(0, happiness[i] - decrement);
            k--; decrement++;
            
            if(k <= 0) {
                return ans;
            }   
        }
        
        return ans;
    }
}