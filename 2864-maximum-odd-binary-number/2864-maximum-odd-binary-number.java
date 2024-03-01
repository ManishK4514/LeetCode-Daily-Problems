class Solution {
    public String maximumOddBinaryNumber(String s) {
        int countOne = 0, n = s.length();
        char[] ch = s.toCharArray();
        for(int i = 0; i < n; i++) if(ch[i] == '1') countOne++;

        for(int i = 0; i < n; i++) {
            if(countOne > 1) {
                ch[i] = '1';
                countOne--;
            }
            else ch[i] = '0';
        }

        ch[n - 1] = '1';

        return String.valueOf(ch); 
    }
}