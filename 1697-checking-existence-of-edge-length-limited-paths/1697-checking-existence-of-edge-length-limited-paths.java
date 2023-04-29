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
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        boolean[] ans = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            queries[i] = new int[]{queries[i][0], queries[i][1], queries[i][2], i};
        }

        Arrays.sort(edgeList, (a, b)->{return a[2] - b[2];});
        Arrays.sort(queries, (a, b)->{return a[2] - b[2];});
        
        DisjointSet ds = new DisjointSet(n);

        int i = 0;
        for(int[] query : queries){
            int limit = query[2];
            while(i < edgeList.length && edgeList[i][2] < limit){
                ds.unionBySize(edgeList[i][0], edgeList[i][1]);
                i++;
            }
            if(ds.findUPar(query[0]) == ds.findUPar(query[1])){
                // query[3] is the original index of query
                ans[query[3]] = true;
            }
            else ans[query[3]] = false;
        }
        return ans;
    }
}