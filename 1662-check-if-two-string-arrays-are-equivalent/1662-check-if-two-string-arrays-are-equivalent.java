class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int n = word1.length, m = word2.length, i = 0, j = 0, l = 0, r = 0;
        
        String s1 = word1[l++];
        String s2 = word2[r++];

        while(true) {
            if(i == s1.length()) {
                if(l == n) return j == s2.length() && r == m;
                s1 = word1[l++];
                i = 0;
            }
            if(j == s2.length()) {
                if(r == m) return i == s1.length() && l == n;
                s2 = word2[r++];
                j = 0;
            }

            if(i == s1.length() && j == s2.length()) {
                if(l == n && r == m) return true;
            }
            
            if(s1.charAt(i) != s2.charAt(j)) return false;
            i++; j++;
        }
    }
}