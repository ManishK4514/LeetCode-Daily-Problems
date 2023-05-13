class Solution {
    static int mod = (int)(1e9 + 7);
    public int helper(int zero, int one, int size, int[] dp){
        if(size < 0) return 0;
        if(size == 0) return 1;
        if(dp[size] != -1) return dp[size];
        
        // adding zero        
        int a = (helper(zero, one, size - zero, dp) % mod);

        // adding one
        int b = (helper(zero, one, size - one, dp) % mod);

        return dp[size] = (a + b) % mod;
    }
    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp = new int[high + 1];
        Arrays.fill(dp, -1);
        int ans = 0;
        for(int i = low; i <= high; i++){
            ans = ((ans % mod) + helper(zero, one, i, dp) % mod) % mod;
        }
        return ans;
    }
}