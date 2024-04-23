class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        int[] degree = new int[n];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
            degree[edge[0]]++;
            degree[edge[1]]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(degree[i] == 1) q.add(i);
        }

        ArrayList<Integer> ans = new ArrayList<>();

        while(!q.isEmpty()){
            int size = q.size();
            ans.clear();

            for(int i = 0; i < size; i++){
                int node = q.remove();
                ans.add(node);

                for(int it : adj.get(node)){                        
                    degree[it]--;
                    degree[node]--;

                    if(degree[it] == 1) q.add(it);
                }
            }
        }

        if(edges.length == 0) ans.add(0);

        return ans;
    }
}