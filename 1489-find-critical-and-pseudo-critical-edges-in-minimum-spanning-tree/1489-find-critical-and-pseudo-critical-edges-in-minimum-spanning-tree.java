class DisjointSet{
    int[] size, parent;
    // Constructor
    DisjointSet(int n){
        size = new int[n + 1];
        parent = new int[n + 1];
        for(int i = 0; i <= n; i++){
            size[i] = 1;
            parent[i] = i;
        }
    }

    // find Ultimate Parent
    public int findUPar(int node){
        if(node == parent[node]) return node;
        return parent[node] = findUPar(parent[node]);
    }

    // Unioun by Rank
    public void unionBySize(int u, int v){
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if(ulp_u == ulp_v) return;
        if(size[ulp_u] < size[ulp_v]){
            parent[ulp_u] = parent[ulp_v];
            size[ulp_v] += size[ulp_u];
        }
        else{
            parent[ulp_v] = parent[ulp_u];
            size[ulp_u] += size[ulp_v];
        }
    }
}

class Solution {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        List<Integer> critical = new ArrayList<>();
        List<Integer> pseudoCritical = new ArrayList<>();

        HashMap<int[], Integer> index = new HashMap<>();

        for(int i = 0; i < edges.length; i++) {
            index.put(edges[i], i);
        }

        Arrays.sort(edges, (a, b)->{return a[2] - b[2];});

        int originalMST = MST(n, edges, null, null);

        for(int[] edge : edges) {
            int excludeCost = MST(n, edges, null, edge);

            if(excludeCost > originalMST) {
                critical.add(index.get(edge));
            }
            else if(excludeCost == originalMST) {
                int includeCost = MST(n, edges, edge, null);

                if(includeCost == originalMST) {
                    pseudoCritical.add(index.get(edge));
                }
            }
        }

        return Arrays.asList(critical, pseudoCritical);
    }

    private int MST(int n, int[][] edges, int[] include, int[] exclude) {
        DisjointSet ds = new DisjointSet(n);
        int cost = 0;

        if(include != null) {
            if(ds.findUPar(include[0]) != ds.findUPar(include[1])) {
                ds.unionBySize(include[0], include[1]);
                cost += include[2];
            }
        }

        for(int[] edge : edges) {
            if(exclude != edge && ds.findUPar(edge[0]) != ds.findUPar(edge[1])) {
                ds.unionBySize(edge[0], edge[1]);
                cost += edge[2];
            }
        }

        return (ds.size[ds.findUPar(0)] == n) ? cost : Integer.MAX_VALUE; 
    }
}