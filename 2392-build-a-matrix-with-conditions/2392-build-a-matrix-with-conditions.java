class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();        
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] nums : prerequisites){
            adj.get(nums[1]).add(nums[0]);
        }
        
        int[] indegree = new int[n];
        for(int i = 0; i < n; i++){
            for(int it : adj.get(i)){
                indegree[it]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(indegree[i] == 0) q.add(i);
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
        if(k == n) return ans;
        return new int[]{};
    }

    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        if(!canFinish(k + 1, rowConditions)) return new int[][]{};
        if(!canFinish(k + 1, colConditions)) return new int[][]{};

        int[] rowOrder = findOrder(k + 1, rowConditions);
        int[] colOrder = findOrder(k + 1, colConditions);

        int n = rowOrder.length;
        int m = colOrder.length;

        // System.out.println(Arrays.toString(rowOrder));
        // System.out.println(Arrays.toString(colOrder));

        int[] map = new int[401];

        int len = k - 1;

        for(int i = 1; i < n; i++) {
            map[rowOrder[i]] = len;
            len--;
        }

        len = k - 1;
        int[][] ans = new int[k][k];

        for(int i = 1; i < m; i++) {
            int val = colOrder[i];
            int col = m - i - 1;
            int row = map[val];

            ans[row][col] = val;
        }

        return ans;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();        
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] nums : prerequisites){
            adj.get(nums[1]).add(nums[0]);
        }
        
        int[] indegree = new int[n];
        for(int i = 0; i < n; i++){
            for(int it : adj.get(i)){
                indegree[it]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(indegree[i] == 0) q.add(i);
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
        return k == n;
    }
}