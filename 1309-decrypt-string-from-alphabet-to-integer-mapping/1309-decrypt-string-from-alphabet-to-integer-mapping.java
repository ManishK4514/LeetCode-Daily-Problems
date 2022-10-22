class Solution {
    public String freqAlphabets(String str) {
        StringBuilder sb = new StringBuilder();
        int i = str.length() - 1;
        while (i >= 0) {
            if (str.charAt(i) == '#') {
                int num = Integer.parseInt(str.substring(i - 2, i));
                sb.append((char)(num + 96));
                i -= 3;
            } else {
                int num = Integer.parseInt(str.substring(i, i + 1));
                sb.append((char)(num + 96));
                i--;
            }
        }        
        return sb.reverse().toString();
    }
}