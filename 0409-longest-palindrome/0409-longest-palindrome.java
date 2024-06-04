class Solution {
    public int longestPalindrome(String s) {
        int[] freq = new int[58];

        for(int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'A']++;
        }

        boolean containsOdd = false;
        int ans = 0;

        for(int i = 0; i < 58; i++) {
            if(freq[i] % 2 != 0) {
                containsOdd = true;
                ans += freq[i] - 1;
            }
            else ans += freq[i];
        }

        return containsOdd ? ans + 1 : ans;
    }
}