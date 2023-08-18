class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        boolean[][] connected = new boolean[n][n];
        int[] indegree = new int[n];
        for (int[] r : roads) {
            indegree[r[0]]++;
            indegree[r[1]]++;
            connected[r[0]][r[1]] = true;
            connected[r[1]][r[0]] = true;  
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                 res = Math.max(res, indegree[i] + indegree[j] - (connected[i][j] ? 1 : 0));
            }
        }           
               
        return res;
    }
}