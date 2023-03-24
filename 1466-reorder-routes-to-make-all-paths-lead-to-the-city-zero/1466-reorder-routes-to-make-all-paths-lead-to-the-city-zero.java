class Solution {
    public int dfs(ArrayList<ArrayList<Integer>> adj, int[] vis, int node){
        vis[node] = 1;
        int change = 0;
        for(int it : adj.get(node)){
            if(vis[Math.abs(it)] == 0){
                change += dfs(adj, vis, Math.abs(it));
                if(it > 0) change++;
            }
        }
        return change;
    }
    public int minReorder(int n, int[][] connections) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int i = 0; i < connections.length; i++){
            adj.get(connections[i][0]).add(connections[i][1]);
            adj.get(connections[i][1]).add(-connections[i][0]);
        }
        int[] vis = new int[n];
        return dfs(adj, vis, 0);
    }
}