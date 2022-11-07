class Solution {
    public boolean isPowerOfTwo(int n) {
        double temp = 0;
        int i = 0;
        while(temp < n){
            temp = Math.pow(2, i);
            if(temp == n){
                return true;
            }
            i++;
        }
        return false;
    }
}