class DisjointSet{
    int[] rank, parent;
    // Constructor
    DisjointSet(int n){
        rank = new int[n + 1];
        parent = new int[n + 1];
        for(int i = 0; i <= n; i++){
            parent[i] = i;
        }
    }

    // find Ultimate Parent
    public int findUPar(int node){
        if(node == parent[node]) return node;
        return parent[node] = findUPar(parent[node]);
    }

    // Union by Rank
    public void unionByRank(int u, int v){
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if(ulp_u == ulp_v) return;
        if(rank[ulp_u] < rank[ulp_v]){
            parent[ulp_u] = parent[ulp_v];
        }
        else if(rank[ulp_u] < rank[ulp_v]){
            parent[ulp_v] = parent[ulp_u];
        }
        else{
            parent[ulp_v] = parent[ulp_u];
            rank[ulp_u]++;
        }
    }
}
class Solution {
    public int minimumSpanningTree(int V, int[][] edges){
	    DisjointSet ds = new DisjointSet(V);
	    Arrays.sort(edges, (a, b)->{
	        return a[2] - b[2];
	    });
	    int ans = 0;
        for(int[] edge : edges){
            if(ds.findUPar(edge[0]) != ds.findUPar(edge[1])){
                ds.unionByRank(edge[0], edge[1]);
                ans += edge[2];
            }
        }
        return ans;
	}
    public int minCostConnectPoints(int[][] points) {
        int n = points.length, idx = 0;

        int[][] edges = new int[n * (n - 1)][3];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i == j) continue;

                int x1 = points[i][0], y1 = points[i][1];
                int x2 = points[j][0], y2 = points[j][1];
                int dist = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                edges[idx++] = new int[]{i, j, dist};
            }
        }

        return minimumSpanningTree(n, edges);
    }
}