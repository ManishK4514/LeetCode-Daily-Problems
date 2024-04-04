class Solution {
    public int maxDepth(String s) {
        int n = s.length(), max = 0, openBracket = 0;
        for(int i = 0; i < n; i++) {
            if(s.charAt(i) == ')') openBracket--;
            else if(s.charAt(i) == '(') openBracket++;
            max = Math.max(max, openBracket);
        }
        return max;
    }
}