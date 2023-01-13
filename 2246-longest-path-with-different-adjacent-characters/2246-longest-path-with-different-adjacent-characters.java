class Solution {
    int res = 0;
    public int dfs(int src, ArrayList<ArrayList<Integer>> adj, String s){
        int ans = 1;
        int max1 = 0, max2 = 0;

        for(int curr : adj.get(src)){
            int temp = dfs(curr, adj, s);
            if(s.charAt(src) != s.charAt(curr)){
                if(temp > max1){
                    max2 = max1;
                    max1 = temp;
                }
                else if(temp > max2){
                    max2 = temp;
                }
            }
        }
        res = Math.max(max1+1+max2, res);
        return 1 + max1;
    }
    public int longestPath(int[] parent, String s) {
        int n = parent.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 1; i < n; i++){
            adj.get(parent[i]).add(i);
        }
        dfs(0, adj, s);
        return res;
    }
}