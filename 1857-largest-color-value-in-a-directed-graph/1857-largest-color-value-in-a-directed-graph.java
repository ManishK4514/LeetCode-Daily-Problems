class Solution {
    public boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] vis, int[] pathVis){
        vis[node] = 1;
        pathVis[node] = 1;
        for(int it : adj.get(node)){
            if(vis[it] == 0){
                if(dfs(it, adj, vis, pathVis) == true) return true;
            }
            else if(pathVis[it] == 1) return true;
        }
        pathVis[node] = 0;
        return false;
    }
    public boolean isCyclic(int n, ArrayList<ArrayList<Integer>> adj) {
        int[] vis = new int[n];
        int[] pathVis = new int[n];
        for(int i = 0; i < n; i++){
            if(vis[i] == 0){
                if(dfs(i, adj, vis, pathVis) == true) return true;
            }
        }
        return false;
    }
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int i = 0; i < edges.length; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
        }
        if(isCyclic(n, adj)) return -1;

        int[] indegree = new int[n];
        for(int[] it : edges){
            indegree[it[1]]++;
        }

        int[][] count = new int[n][26];
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < n; i++){
            if(indegree[i] == 0){
                q.add(i);
                count[i][colors.charAt(i) - 'a']++;
            }
        }
        
        int ans = 0;
        while(!q.isEmpty()){
            int node = q.remove();

            int r = 0;
            for(int it : count[node]) r = Math.max(r, it);
            ans = Math.max(ans, r);

            for(int it : adj.get(node)){
                for(int i = 0; i < 26; i++){
                    int curr =  0;
                    if(i == (colors.charAt(it) - 'a')) curr = 1;
                    count[it][i] = Math.max(count[it][i], count[node][i] + curr);
                }
                if(--indegree[it]==0){
                    q.add(it);
                }
            }
        }
        return ans;
    }
}