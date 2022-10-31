class Solution {
    public boolean valid(int[] freq, int k, int i, int j){
        int max = Integer.MIN_VALUE;
        for(int u = 0; u < freq.length; u++){
            max = Math.max(max, freq[u]);
        }
        return (((j - i) + 1) - max) <= k;
    }
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int i = 0, j = 0, ans = 0;
        while(j < s.length()){
            freq[s.charAt(j) - 'A']++;
            if(valid(freq, k, i, j)){
                ans = Math.max(ans, (j - i) + 1);
            }
            else{
                freq[s.charAt(i) - 'A']--;
                i++;
            }
            j++;
        }
        return ans;
    }
}