class Solution {
    public boolean isValid(int src, List<List<Integer>> adj, int[] vis) {
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        vis[src] = 1;
        
        while(!q.isEmpty()) {
            int node = q.remove();

            for(int it : adj.get(node)) {
                if(vis[it] == 0) {
                    vis[it] = 1;
                    q.add(it);
                }
                else return true;
            }
        }

        return false;
    }
    public int dfs(int node, List<List<Integer>> parent) {
        while(parent.get(node).size() > 0) {
            node = parent.get(node).get(0);
        }
        return node;
    }
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());

        List<List<Integer>> parent = new ArrayList<>();
        for(int i = 0; i < n; i++) parent.add(new ArrayList<>());

        for(int i = 0; i < n; i++) {
            if(leftChild[i] != -1) adj.get(i).add(leftChild[i]);
            if(rightChild[i] != -1) adj.get(i).add(rightChild[i]);

            if(leftChild[i] != -1) parent.get(leftChild[i]).add(i);
            if(rightChild[i] != -1) parent.get(rightChild[i]).add(i);
        }
        
        int[] vis = new int[n];

        if(isValid(0, adj, vis)) return false;

        int par = dfs(0, parent);

        Arrays.fill(vis, 0);
        if(isValid(par, adj, vis)) return false;

        for(int i = 0; i < n; i++) {
            if(vis[i] == 0) return false;
        }

        return true;
    }
}