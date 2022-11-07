class Solution {
    public boolean isPowerOfTwo(int n) {        
        while(n > 0){
            if(n == 1){
              return true;
            }
            if((n&1) == 1){
                return false;
            }
            n = n>>1;
        }
        return false;
    }
}