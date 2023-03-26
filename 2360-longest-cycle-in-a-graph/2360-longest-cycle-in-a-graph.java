class Solution {
    int ans = -1;
    public void dfs(ArrayList<ArrayList<Integer>> adj, int[] vis, int node, int d, int[] dist_node, int[] extra){        
        for(int it : adj.get(node)){
            if(vis[it] == 0) {
                vis[it] = 1;
                extra[it] = 1;
                dist_node[it] = d;
                dfs(adj, vis, it, d + 1, dist_node, extra);               
            }
            else if(extra[it] == 1){
                ans = Math.max(ans, d - dist_node[it]);
            }
            extra[it] = 0;
        }
    }
    public int longestCycle(int[] edges) {
        int n = edges.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int i = 0; i < n; i++){
            if(edges[i] != -1) adj.get(i).add(edges[i]);
        }
        int[] dist_node = new int[n];
        int[] vis = new int[n];
        int[] extra = new int[n];
        for(int i = 0; i < n; i++){ 
            if(vis[i] == 0) dfs(adj, vis, i, 0, dist_node, extra);
        }
        return ans;
    }
}