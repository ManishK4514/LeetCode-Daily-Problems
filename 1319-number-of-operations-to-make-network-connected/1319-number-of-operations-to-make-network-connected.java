class Solution {
    public void dfs(ArrayList<ArrayList<Integer>> adj, int[] vis, int node){
       vis[node] = 1;
       for(int it : adj.get(node)){
           if(vis[it] == 0) dfs(adj, vis, it);
       }
    }
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n - 1) return -1;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int i = 0; i < connections.length; i++){
            adj.get(connections[i][0]).add(connections[i][1]);
            adj.get(connections[i][1]).add(connections[i][0]);
        }
        int[] vis = new int[n];
        int ans = 0;
        for(int i = 0; i < n; i++){
            if(vis[i] == 0) {
                ans++;
                dfs(adj, vis, i);
            }
        }
        return ans - 1;
    }
}