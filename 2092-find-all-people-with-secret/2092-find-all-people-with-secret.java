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
            parent[ulp_u] = ulp_v;
            size[ulp_v] += size[ulp_u];
        }
        else{
            parent[ulp_v] = ulp_u;
            size[ulp_u] += size[ulp_v];
        }
    }
}

class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        int m = meetings.length;
        DisjointSet ds = new DisjointSet(n);
        Arrays.sort(meetings, (a, b) -> a[2] - b[2]);
        
        ds.unionBySize(0, firstPerson);

        for(int i = 0; i < m; i++) {
            int currTime = meetings[i][2];
            List<Integer> currPeople = new LinkedList<>();

            while(i < m && meetings[i][2] == currTime) {
                ds.unionBySize(meetings[i][0], meetings[i][1]);
                currPeople.add(meetings[i][0]);
                currPeople.add(meetings[i][1]);
                i++;
            }

            for(int it : currPeople) {
                if(ds.findUPar(it) != ds.findUPar(0)) {
                    // unlink or reset
                    ds.parent[it] = it;
                }                
            }
            i--;
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) if (ds.findUPar(i) == ds.findUPar(0)) res.add(i);
        return res;
    }
}
