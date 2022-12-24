class Solution {
    public int numTilings(int n) {        
        long[] res = new long[10001];
        res[0] = 0; res[1] = 1; res[2] = 2; res[3] = 5;
        if(n < 3) return (int) res[n];
        else{
            for(int i = 4; i <= n; i++){
                res[i] = (2 * res[i - 1]) + res[i - 3];
                res[i] %= 1000000007;
            }
        }
        return (int) res[n];
    }
}