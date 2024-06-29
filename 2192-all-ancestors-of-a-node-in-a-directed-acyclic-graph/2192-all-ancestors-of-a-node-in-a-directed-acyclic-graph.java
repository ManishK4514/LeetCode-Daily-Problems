class Solution {
    public void dfs(int node, ArrayList<ArrayList<Integer>> adj, List<Integer> ancestors, int[] vis) {        
        for(int it : adj.get(node)) {
            if(vis[it] == 0) {
                ancestors.add(it);
                vis[it] = 1;
                dfs(it, adj, ancestors, vis);
            }
        }
    }
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for(int[] edge : edges) {
            adj.get(edge[1]).add(edge[0]);
        }

        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            List<Integer> ancestors = new ArrayList<>();
            int[] vis = new int[n];
            dfs(i, adj, ancestors, vis);
            Collections.sort(ancestors);
            res.add(ancestors);
        }

        return res;
    }
}