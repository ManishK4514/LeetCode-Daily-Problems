class Solution {
    public int minAddToMakeValid(String s) {
        int open = 0, close = 0, count = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') open++;
            else close++;

            if(close > open) {
                count++;
                open++;
            }
        }
        return Math.abs(open - close) + count;
    }
}