class Solution {
    public int dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] vis){
        vis[node] = 1;
        int count = 1;
        for(int it : adj.get(node)){
            if(vis[it] == 0) {
                count += dfs(it, adj, vis);
            }
        }
        return count;
    }
    public long countPairs(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        long notMakePair = 0;
        int[] vis = new int[n];
        for(int i = 0; i < n; i++){
            if(vis[i] == 0) {
                // count of the curr componect
                long curr = dfs(i, adj, vis);
                notMakePair += curr * (curr - 1)/2;
            }
        }
        
        long totalUniquePair = 1L * n * (n - 1)/2;
        
        return totalUniquePair - notMakePair;
    }
}