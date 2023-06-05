class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        // Slope (m) = (y2 - y1) / (x2 - x1)
        double x1 = coordinates[0][0], y1 = coordinates[0][1];
        double x2 = coordinates[1][0], y2 = coordinates[1][1];

        double m;
        if(x2 - x1 == 0) m = (int)1e9;
        else m = (y2 - y1) / (x2 - x1);

        for(int i = 2; i < coordinates.length; i++){
            x2 = coordinates[i][0]; y2 = coordinates[i][1];
            x1 = coordinates[i - 1][0]; y1 = coordinates[i - 1][1];

            double curr;
            if(x2 - x1 == 0) curr = (int)1e9;
            else curr = (y2 - y1) / (x2 - x1);
            // System.out.println(curr + " " + m);
            if(curr != m) return false;
        }
        return true;
    }
}