class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();

        while(columnNumber > 0) {
            int k = columnNumber % 26;
            if(k == 0) sb.append('Z');
            else sb.append((char)('A' + (k - 1)));
            columnNumber /= 26;
            if(k == 0) columnNumber--;
        }

        return sb.reverse().toString();
    }
}