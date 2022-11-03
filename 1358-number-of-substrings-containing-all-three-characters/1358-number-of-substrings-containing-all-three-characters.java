class Solution {
    public int numberOfSubstrings(String s) {
        int count = 0;
        int idx_a = -1, idx_b = -1, idx_c = -1;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'a'){
                idx_a = i;
            }
            else if(s.charAt(i) == 'b'){
                idx_b = i;
            }
            else{
                idx_c = i;
            }
            if(i > 1){
                int min = Math.min(idx_a, idx_b);
                min = Math.min(min, idx_c);
                count += min + 1;
            }
        }
        return count;
    }
}