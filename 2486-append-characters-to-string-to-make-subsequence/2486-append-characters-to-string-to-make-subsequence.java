class Solution {
    public int appendCharacters(String s, String t) {
        int l = 0, r = 0, n = s.length(), m = t.length();

        while(l < n && r < m) {
            if(s.charAt(l) == t.charAt(r)) {
                l++; r++;
            }
            else l++;
        }

        return m - r;
    }
}