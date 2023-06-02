class Solution {
    public int dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] vis){
        vis[node] = 1;
        int ans = 1;
        for(int it : adj.get(node)){
            if(vis[it] == 0){
                int curr = dfs(it, adj, vis);
                ans += curr;
            }
        }
        return ans;
    }
    public int maximumDetonation(int[][] bombs) {
        // distance = sqrt((x2 - x1)^2 + (y2 - y1)^2)
        // distance <= r
        
        int n = bombs.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                int x1 = bombs[i][0], y1 = bombs[i][1], r1 = bombs[i][2];
                int x2 = bombs[j][0], y2 = bombs[j][1], r2 = bombs[j][2];

                double distance1 = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1),2));
                double distance2 = Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2),2));
                
                if(distance1 <= r1){
                    adj.get(i).add(j);                    
                }
                if(distance2 <= r2){
                    adj.get(j).add(i);
                }
            }
        }
        
        int ans = 0;

        for(int i = 0; i < n; i++){
            int[] vis = new int[n];
            int curr = dfs(i, adj, vis);
            ans = Math.max(ans, curr);
        }

        return ans;
    }
}