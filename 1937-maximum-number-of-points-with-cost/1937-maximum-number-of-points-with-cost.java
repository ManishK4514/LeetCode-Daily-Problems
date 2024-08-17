class Solution {
    public long maxPoints(int[][] points) {
        int row = points.length;
        int col = points[0].length;
        long[] dp = new long[col];
        
        for (int i = 0; i < col; i++) {
            dp[i] = points[0][i];
        }
        
        for (int r = 1; r < row; r++) {
            long[] leftMax = new long[col];
            long[] rightMax = new long[col];
            long[] newDp = new long[col];
            
            leftMax[0] = dp[0];
            for (int i = 1; i < col; i++) {
                leftMax[i] = Math.max(leftMax[i-1], dp[i] + i);
            }
            
            rightMax[col-1] = dp[col-1] - (col-1);
            for (int i = col-2; i >= 0; i--) {
                rightMax[i] = Math.max(rightMax[i+1], dp[i] - i);
            }
            
            for (int i = 0; i < col; i++) {
                newDp[i] = Math.max(leftMax[i] - i, rightMax[i] + i) + points[r][i];
            }
            
            dp = newDp;
        }
        
        long result = Long.MIN_VALUE;
        for (long value : dp) {
            result = Math.max(result, value);
        }
        
        return result;
    }
}