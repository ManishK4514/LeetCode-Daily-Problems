class Solution {
    public int minimumOneBitOperations(int n) {
        long[] dp = new long[31];
        dp[0] = 1;

        for(int i = 1; i <= 30; i++) dp[i] = 2 * dp[i - 1] + 1;

        long ans = 0, count = 0;

        for(int i = 30; i >= 0; i--) {
            if(((1 << i) & n) > 0) {
                count++;
                if(count % 2 != 0) ans += dp[i];
                else ans -= dp[i];
            }
        }

        return (int) ans;
    }
}