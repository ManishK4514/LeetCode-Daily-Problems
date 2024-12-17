class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] count = new int[26];
        for(char ch : s.toCharArray()) count[ch - 'a']++;

        int r = 24;
        StringBuilder sb = new StringBuilder();

        for(int i = 25; i >= 0 ; i--){
            r = Math.min(r, i - 1);
            while(count[i] != 0){
                int curr;
                if(count[i] > repeatLimit){
                    curr = repeatLimit;
                    while(curr-- > 0 ) sb.append((char)('a' + i));
                    while(r >= 0 && count[r] == 0) r--;
                    if(r < 0) return sb.toString();
                    sb.append((char)('a' + r));
                    count[r]--;
                    count[i] -= repeatLimit;
                }
                else{
                    curr = count[i];
                    while(curr-- > 0) sb.append((char)('a' + i));
                    count[i] = 0;
                }
            }
        }
                
        return sb.toString();
    }
}