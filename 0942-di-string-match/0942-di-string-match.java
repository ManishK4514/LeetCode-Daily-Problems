class Solution {
    public int[] diStringMatch(String s) {
        int[] res = new int[s.length() + 1];
        int high = s.length();
        int low = 0, k = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'D'){
                res[k++] = high;
                high--;
            }
            else{
                res[k++] = low;
                low++;
            }
        }
        res[k++] = high;
        return res;
    }
}