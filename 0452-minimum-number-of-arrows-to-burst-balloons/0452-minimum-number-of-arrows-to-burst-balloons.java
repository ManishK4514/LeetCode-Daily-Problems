class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int arrows = 1, n = points.length;
        int prevEndPoint = points[0][1];

        for(int i = 1; i < n; i++) {
            if(prevEndPoint < points[i][0]) {
                arrows++;
                prevEndPoint = points[i][1];
            }
        }

        return arrows;
    }
}