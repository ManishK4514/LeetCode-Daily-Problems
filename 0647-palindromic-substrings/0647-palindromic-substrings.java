class Solution {
    public int countSubstrings(String s) {
        int n = s.length(), count = 0;
        for(int i = 0; i < n; i++) {
            count++;
            
            // even (j, j - 1)
            int l = i - 1, r = i;
            while(l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                count += 1;
                l--; r++;
            }

            // odd (j - 1, j + 1)
            l = i - 1; r = i + 1;
            while(l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                count += 1;
                l--; r++;
            }
        }

        return count;
    }
}