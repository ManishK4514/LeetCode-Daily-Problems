class Solution {
    public int numSpecial(int[][] mat) {
        int n = mat.length, m = mat[0].length, ans = 0;
        int[] row = new int[n];
        int[] col = new int[m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(mat[i][j] == 1) {
                    row[i]++; col[j]++;
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(mat[i][j] == 1 && row[i] == 1 && col[j] == 1) ans++;
            }
        }
        
        return ans;
    }
}