class Solution {
    public String addSpaces(String s, int[] spaces) {
        int n = s.length(), j = 0, m = spaces.length;
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++) {
            if(j < m && spaces[j] == i) {
                sb.append(" ");
                j++;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}