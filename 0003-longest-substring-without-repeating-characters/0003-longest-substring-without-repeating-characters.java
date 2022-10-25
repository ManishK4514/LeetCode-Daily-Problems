class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int[] cnt = new int[128];
        for(int i = 0; i < s.length(); i++){
            int distCount = 0;
            Arrays.fill(cnt, 0);
            for(int j = i; j < s.length(); j++){
                if(cnt[s.charAt(j)] == 0){
                    distCount++;
                }
                else{
                    break;
                }
                cnt[s.charAt(j)]++;
                max = Math.max(max, distCount);
            }           
        }
        return max;
    }
}