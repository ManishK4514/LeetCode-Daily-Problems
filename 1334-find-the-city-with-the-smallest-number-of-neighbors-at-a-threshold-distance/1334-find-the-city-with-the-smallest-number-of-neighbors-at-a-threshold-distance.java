class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] matrix = new int[n][n];
        for(int[] mat : matrix) Arrays.fill(mat, (int)(1e9));
        for(int i = 0; i < edges.length; i++){
            matrix[edges[i][0]][edges[i][1]] = edges[i][2];
            matrix[edges[i][1]][edges[i][0]] = edges[i][2];
        }
        for(int i = 0; i < n; i++) matrix[i][i] = 0;

        // Floyd Warshall
        for(int k = 0; k < n; k++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }

        int minCity = Integer.MAX_VALUE, cityNo = -1;        
        for(int i = 0; i < n; i++){
            int city = 0;
            for(int j = 0; j < n; j++){
                if(matrix[i][j] <= distanceThreshold) city++;
            }
            if(minCity >= city){
                minCity = city;
                cityNo = i;
            }
        }
        return cityNo;
    }
}