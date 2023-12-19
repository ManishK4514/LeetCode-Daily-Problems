class Solution {
    private int getSmoothedValue(int[][] img, int x, int y, int n, int m) {
        int sum = 0;
        int count = 0;

        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                int ni = x + dx;
                int nj = y + dy;

                if (ni >= 0 && ni < n && nj >= 0 && nj < m) {
                    sum += img[ni][nj];
                    count++;
                }
            }
        }
        return sum / count;
    }
    
    public int[][] imageSmoother(int[][] img) {        
        int n = img.length, m = img[0].length;
        int[][] res = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res[i][j] = getSmoothedValue(img, i, j, n, m);
            }
        }

        return res;
    }
}
