class Solution {
    public int maxPoints(int[][] p) {
        int n = p.length;
        if(n <= 2) return n;
        int maxi = 2;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                int total = 2;
                for(int k = 0; k < n; k++){
                    if(k != i && k != j){
                        // slope of a line using two point (x1, y1) && (x2, y2) is (y2 - y1) / (x2 - x1);
                        // and to check whether any third point lie on the same line or not 
                        // we check
                        // (y2 - y1) / (x2 - x1) == (y3 - y1) / (x3 - x1) or we can use also
                        // (y2 - y1) / (x2 - x1) == (y2 - y3) / (x2 - x3)
                        if((p[j][1] - p[i][1]) * (p[k][0] - p[i][0]) == (p[k][1] - p[i][1]) * (p[j][0] - p[i][0])) total++;
                    }
                }
                maxi = Math.max(total, maxi);
            }
        }
        return maxi;
    }
}