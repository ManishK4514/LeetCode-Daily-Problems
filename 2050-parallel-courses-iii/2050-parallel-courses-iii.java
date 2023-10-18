class Solution {
    public int[] topoSort(int n, ArrayList<ArrayList<Integer>> adj) {
        int[] indegree = new int[n];
        for(int i = 0; i < n; i++) {
            for(int it : adj.get(i)) {
                indegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            
            if(indegree[i] == 0) {
                q.add(i);
            }
        }

        int[] ans = new int[n];
        int k = 0;
        while(!q.isEmpty()){
            int node = q.remove();
            ans[k++] = node;

            for(int it : adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0) q.add(it);
            }
        }
        return ans;
    }
    public int minimumTime(int n, int[][] relations, int[] time) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++) adj.add(new ArrayList<>());

        for(int[] relation : relations) adj.get(relation[0]).add(relation[1]);

        int[] toposort = topoSort(n + 1, adj);        
        int[] maxArr = new int[n + 1];

        for(int i = 1; i <= n; i++) maxArr[i] = time[i - 1];

        for(int i = 0; i <= n; i++) {
            for(int it : adj.get(toposort[i])) {
                int currValue = maxArr[toposort[i]] + time[it - 1];
                if(maxArr[it] < currValue) {
                    maxArr[it] = currValue;
                }
            }
        }

        int max = -1;
        for(int i = 1; i <= n; i++)  max = Math.max(max, maxArr[i]);

        return max;
    }
}