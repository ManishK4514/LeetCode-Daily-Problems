class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0, n = s.length(), m = t.length();
        for(int j = 0; j < m; j++) {
            if(i < n && s.charAt(i) == t.charAt(j)) i++;            
        }
        return i == n;
    }
}