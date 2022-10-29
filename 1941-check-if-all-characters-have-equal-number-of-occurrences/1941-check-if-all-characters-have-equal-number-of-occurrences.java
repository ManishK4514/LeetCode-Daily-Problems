class Solution {
    public boolean areOccurrencesEqual(String s) {
        int[] freq = new int[26];
        for(int i = 0; i < s.length(); i++){
            freq[s.charAt(i) - 'a']++;
        }
        int prev = freq[s.charAt(0) - 'a'];
        for(int i = 0; i < freq.length; i++){
            if(freq[i] != 0 && freq[i] != prev){
                return false;
            }
        }
        return true;
    }
}