class Solution {
    public String mergeAlternately(String w1, String w2) {
        int n = w1.length(), m = w2.length(), i = 0, j = 0;
        StringBuilder res = new StringBuilder();
        while (i < n || j < m) {
            if (i < w1.length())
                res.append(w1.charAt(i++));
            if (j < w2.length())
                res.append(w2.charAt(j++));
        }
        return res.toString();
    }
}