class Solution {
    public boolean dfs(int src, int par, HashMap<Integer, List<Integer>> adj, int[] ans, int idx) {
        ans[idx] = src;

        for(int it : adj.get(src)) {
            if(it != par) {
                if(dfs(it, src, adj, ans, idx + 1)) return true;
            }
        }

        return false;
    }
    public int[] restoreArray(int[][] adjacentPairs) {
        int n = adjacentPairs.length + 1;
        HashMap<Integer, List<Integer>> adj = new HashMap<>();

        for(int[] adjacent : adjacentPairs) {
            adj.putIfAbsent(adjacent[0], new ArrayList<>());
            adj.get(adjacent[0]).add(adjacent[1]);
            adj.putIfAbsent(adjacent[1], new ArrayList<>());
            adj.get(adjacent[1]).add(adjacent[0]);
        }

        int[] ans = new int[n];

        for(int key : adj.keySet()) {
            if(adj.get(key).size() == 1) {
                dfs(key, -1, adj, ans, 0);
                return ans;
            }
        }

        return new int[]{};        
    }
}