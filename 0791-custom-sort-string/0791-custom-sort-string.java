class Solution {
    public String customSortString(String order, String s) {
        int[] index = new int[26];
        Arrays.fill(index, 27);
        for(int i = 0; i < order.length(); i++) index[order.charAt(i) - 'a'] = i;
        Character[] charArray = new Character[s.length()];
        for (int i = 0; i < s.length(); i++) {
            charArray[i] = s.charAt(i);
        }
        Arrays.sort(charArray, (a, b)->{
            return index[a - 'a'] - index[b - 'a'];
        });
        StringBuilder sb = new StringBuilder();
        for (char c : charArray) {
            sb.append(c);
        }
        return sb.toString();
    }
}