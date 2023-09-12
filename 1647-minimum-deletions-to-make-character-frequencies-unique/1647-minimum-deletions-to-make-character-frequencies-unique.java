class Solution {
    public int minDeletions(String s) {
        int n = s.length();
        int[] freq = new int[26];
        for(int i = 0; i < n; i++) freq[s.charAt(i) - 'a']++;

        Arrays.sort(freq);

        int del = 0;

        for (int i = 24; i >= 0; i--) {
            if (freq[i] == 0) break;
            
            if (freq[i] >= freq[i + 1]) {
                int prev = freq[i];
                freq[i] = Math.max(freq[i + 1] - 1, 0);
                del += prev - freq[i];
                
            }
        }

        return del;
    }
}