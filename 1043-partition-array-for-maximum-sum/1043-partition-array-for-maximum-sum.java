class Solution {
    public int helper(int i, int[] arr, int k, int[][] dp) {
        if(i == arr.length) return 0;

        if(dp[i][k] != -1) return dp[i][k];
        
        int ans = 0, count = 1, max = 0;
        for(int j = i; j < Math.min(arr.length, i + k); j++) {
            max = Math.max(max, arr[j]);
            ans = Math.max(ans, max * count + helper(j + 1, arr, k, dp));
            count++;
        }

        return dp[i][k] = ans;
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[][] dp = new int[n][n + 1];
        for(int[] it : dp) Arrays.fill(it, -1);
        return helper(0, arr, k, dp);
    }
}