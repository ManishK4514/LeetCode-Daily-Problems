class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        int n = points.length, max = 0;
        int[] x = new int[n];
        for(int i = 0; i < n; i++) x[i] = points[i][0];
        Arrays.sort(x);
        for(int i = 1; i < n; i++) max = Math.max(x[i] - x[i - 1], max);
        return max;
    }
}