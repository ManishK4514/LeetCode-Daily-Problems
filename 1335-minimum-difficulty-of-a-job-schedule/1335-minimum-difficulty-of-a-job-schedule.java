class Solution {
    private int dfs(int d, int len, int[] jobDifficulty, int[][] dp){
        final int N = jobDifficulty.length;
        if(d == 0 && len == N) return 0;
        if(d == 0 || len == N) return Integer.MAX_VALUE;
        if(dp[len][d] != -1) return dp[len][d];

        int curMax = jobDifficulty[len];
        int min = Integer.MAX_VALUE;
        for(int schedule = len; schedule < N; ++schedule){
            curMax = Math.max(curMax, jobDifficulty[schedule]);
            int temp = dfs(d - 1, schedule + 1, jobDifficulty, dp);
            if(temp != Integer.MAX_VALUE)
                min = Math.min(min, temp + curMax);
        }

        return dp[len][d] = min;
    }
    public int minDifficulty(int[] jobDifficulty, int D) {
        final int N = jobDifficulty.length;
        if(N < D) return -1;

        int[][] dp = new int[N][D + 1];
        for(int[] row : dp) Arrays.fill(row, -1);

        return dfs(D, 0, jobDifficulty, dp);
    }
}