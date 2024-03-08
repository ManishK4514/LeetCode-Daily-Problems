class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] map = new int[101];
        int max = 0, ans = 0;
        
        for(int it : nums) {
            map[it]++;
            max = Math.max(max, map[it]);
        }
          
        for(int it : map) if(it == max) ans += it;
        
        return ans;
    }
}