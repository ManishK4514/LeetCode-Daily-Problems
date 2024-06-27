class Solution {
    public int findCenter(int[][] edges) {
        int n = edges.length + 1;
        int[] indegree = new int[n + 1];
        
        for(int[] edge : edges) {
            indegree[edge[0]]++;
            indegree[edge[1]]++;
        }

        for(int i = 0; i <= n; i++) {
            if(indegree[i] == n - 1) return i;
        }

        return -1;
    }
}