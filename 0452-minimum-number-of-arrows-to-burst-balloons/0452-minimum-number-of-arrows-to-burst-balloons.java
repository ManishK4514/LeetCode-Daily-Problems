class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        int lastpoint = points[0][1];
        int ans = 1;
        for(int[] point : points) {
            if(point[0] > lastpoint) {
                ans++;
                lastpoint = point[1];
            }
            lastpoint = Math.min(point[1],lastpoint);
        }
        return ans;
    }
}