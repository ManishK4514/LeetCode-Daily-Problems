class Solution {
    public String minRemoveToMakeValid(String s) {
        char[] charArray = s.toCharArray();
        int open = 0, close = 0, n = s.length();

        for(int i = 0; i < n; i++) {
            if(charArray[i] == '(') open++;
            else if(charArray[i] == ')') {
                close++;

                if(close > open) {
                    close--;
                    charArray[i] = '#';
                }
            }
        }

        for(int i = n - 1; i >= 0; i--) {
            if(open > close && charArray[i] == '(') {
                charArray[i] = '#';
                open--;
            }
        }

        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < n; i++) if(charArray[i] != '#') ans.append(charArray[i]);
        return ans.toString();
    }
}