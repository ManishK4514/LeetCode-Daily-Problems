class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n + 1];
        for(int i = n - 1; i >= 0; i--){
            int jump = questions[i][1], point = questions[i][0]; 
            long t = point + ( (i+1+jump<=n) ? dp[i+1+jump] : 0 );
            long nt = dp[i + 1];
    
            dp[i] = Math.max(t, nt);
        }
        // System.out.println(Arrays.toString(dp));
        return dp[0];
    }
}