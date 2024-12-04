class Solution {
    public static char getNextCharacter(char c) {
        if (c >= 'a' && c < 'z') {
            return (char)(c + 1);
        } 
        else if (c == 'z') {
            return 'a';
        }
        return c;
    }
    public boolean canMakeSubsequence(String str1, String str2) {
        int i = 0, j = 0, n = str1.length(), m = str2.length();
        while(i < n && j < m) {
            if(str1.charAt(i) == str2.charAt(j)) {
                i++; j++;
            }
            else if(getNextCharacter(str1.charAt(i)) == str2.charAt(j)) {
                i++; j++;
            }
            else i++;
        }
        if(j == m) return true;
        return false;
    }
}