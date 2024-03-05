class Solution {
    public int minimumLength(String s) {
        int i = 0, j = s.length() - 1, n = s.length();

        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) return j - i + 1;
            else {
                char ch = s.charAt(i);
                while(i < n && s.charAt(i) == ch) i++; 
                while(j >= 0 && s.charAt(j) == ch) j--;
            }
        }

        return i == j ? 1 : 0;
    }
}