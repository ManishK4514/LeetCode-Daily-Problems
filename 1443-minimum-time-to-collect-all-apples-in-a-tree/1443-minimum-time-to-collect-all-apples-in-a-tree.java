class Solution {
    public int dfs(List<Boolean> hasApple, int node, int d, int prev, ArrayList<ArrayList<Integer>> adj){
        int result = 0;
        int temp;
        for(int curr : adj.get(node)){
            if(curr != prev){
                temp = dfs(hasApple, curr, d + 1, node, adj);
                if(temp != 0){
                    result += temp - d;
                }
            }
        }
        if(result != 0 || hasApple.get(node)){
            return result + d;
        }
        return 0;
    }
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int[] edge: edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        return dfs(hasApple, 0, 0, -1, adj) * 2;
    }
}