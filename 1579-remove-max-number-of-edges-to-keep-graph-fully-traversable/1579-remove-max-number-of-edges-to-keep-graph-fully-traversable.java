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
    public boolean unionBySize(int u, int v){
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if(ulp_u == ulp_v) return false;
        if(size[ulp_u] < size[ulp_v]){
            parent[ulp_u] = parent[ulp_v];
            size[ulp_v] += size[ulp_u];
        }
        else{
            parent[ulp_v] = parent[ulp_u];
            size[ulp_u] += size[ulp_v];
        }
        return true;
    }
}

class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        Arrays.sort(edges, (a, b)->{return b[0] - a[0];});

        DisjointSet alice = new DisjointSet(n);
        DisjointSet bob = new DisjointSet(n);
        
        int redundant = 0;
        int aliceEdges = 0;
        int bobEdges = 0;

        for(int[] edge : edges){
            if(edge[0] == 3){
                if(alice.unionBySize(edge[1], edge[2])) {
                    bob.unionBySize(edge[1], edge[2]); 
                    aliceEdges++;
                    bobEdges++;
                } 
                else {
                    redundant++; 
                }
            }
            else if(edge[0] == 1){
                if (alice.unionBySize(edge[1], edge[2])) {
                    aliceEdges++;
                } 
                else {
                    redundant++;
                }
            }
            else{
                if (bob.unionBySize(edge[1], edge[2])) {
                    bobEdges++;
                } 
                else {
                    redundant++;
                }
            }
        }
        
        return (bobEdges == n - 1 && aliceEdges == n - 1) ? redundant : -1;
    }
}