class Solution {
    public void dfs(int[] dist, int node, int[] vis, ArrayList<ArrayList<Integer>> adj, int d){
        vis[node] = 1;
        dist[node] += d;
        for(int it : adj.get(node)){
            if(vis[it] == 0){
                dfs(dist, it, vis, adj, d + 1);
            }
        }
    }
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = edges.length;
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < n; i++){
            if(edges[i] != -1)adj.get(i).add(edges[i]);
        }
        int[] vis1 = new int[n];
        int[] vis2 = new int[n];

        int[] dist1 = new int[n];
        int[] dist2 = new int[n];
        
        Arrays.fill(dist1, -1);
        Arrays.fill(dist2, -1);
        
        dfs(dist1, node1, vis1, adj, 1);
        dfs(dist2, node2, vis2, adj, 1);
        
        int minDis = Integer.MAX_VALUE;
        int ans = -1;

        for(int i = 0; i < n; i++){
            if(dist1[i] != -1 && dist2[i] != -1) {
                if(minDis > Math.max(dist1[i], dist2[i])){
                    minDis = Math.max(dist1[i], dist2[i]);
                    ans = i;
                }
            }
        }
        return ans;
    }
}