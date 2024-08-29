class Solution {
    public int dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] vis) {
        vis[node] = 1;

        int count = 0;

        for(int it : adj.get(node)) {
            if(vis[it] == 0) {
                count += dfs(it, adj, vis);
            }
        }

        return count + 1;
    }

    public int removeStones(int[][] stones) {
        int n = stones.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        int[] vis = new int[n];
        int ans = 0;

        for(int i = 0; i < n; i++) {
            if(vis[i] == 0) {
                int curr = dfs(i, adj, vis);
                ans += curr - 1;
            }
        }

        return ans;
    }
}