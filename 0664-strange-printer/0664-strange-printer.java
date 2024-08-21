class Solution {
    public int helper(int i, int j, String s, int[][] dp){
        if(i > j) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int ans = Integer.MAX_VALUE;

        for(int k = i; k <= j; k++){
            int startIdx = k;

            while(s.charAt(k) == s.charAt(startIdx)) k++;

            int curr = 0;

            if(startIdx > i) {
                curr += helper(i, startIdx - 1, s, dp);
            }

            if(k <= j){
                curr += helper(k, j, s, dp);
            }

            if(s.charAt(startIdx) != s.charAt(i - 1)) curr++;

            ans = Math.min(ans, curr);
            k--;
        }

        return dp[i][j] = ans;
    }
    public int strangePrinter(String s) {
        int n = s.length();
        s = '0' + s;
        s = s + '0';

        int[][] dp = new int[n + 2][n + 2];
        for(int[] it : dp) Arrays.fill(it, -1);
        return helper(1, n, s, dp);
    }
}