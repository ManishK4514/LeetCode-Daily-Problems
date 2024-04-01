class Solution {
    public int lengthOfLastWord(String s) {
        int j = s.length() - 1, length = 0;
        while(s.charAt(j) == ' ') j--;

        while(j >= 0 && s.charAt(j) != ' ') {
            j--; length++;
        }

        return length;
    }
}