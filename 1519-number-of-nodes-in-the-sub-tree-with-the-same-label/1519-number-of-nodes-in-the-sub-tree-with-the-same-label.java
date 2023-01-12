class Solution {
    public int[] dfs(int node, int[] res, ArrayList<ArrayList<Integer>> adj, int parent, String labels){
        int[] count = new int[26];
        for (int curr : adj.get(node)) {
            if (curr != parent) {
                int[] adjCount = dfs(curr, res, adj, node, labels);
                for(int i = 0; i < 26; i++){
                    count[i] += adjCount[i];
                }
            }
        }
        char ch = labels.charAt(node);
        count[ch - 'a']++;
        res[node] = count[ch - 'a'];
        return count;
    }
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        int[] res = new int[n];
        dfs(0, res, adj, -1, labels);
        return res;
    }
}