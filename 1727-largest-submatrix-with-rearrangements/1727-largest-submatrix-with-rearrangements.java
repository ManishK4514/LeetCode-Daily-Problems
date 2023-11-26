class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length, ans = 0;

        for(int i = 1; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(matrix[i][j] == 1) {
                    matrix[i][j] += matrix[i - 1][j];
                }
            }
        } 

        for(int[] it : matrix) {
            Arrays.sort(it);

            int min = Integer.MAX_VALUE;

            for(int i = m - 1, len = 1; i >= 0; i--, len++) {
                min = Math.min(min, it[i]);
                ans = Math.max(ans, min * len);
            }
        }

        return ans;
    }
}