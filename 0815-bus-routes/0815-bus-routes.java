class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        HashMap<Integer, HashSet<Integer>> adj = new HashMap<>();
        int n = routes.length;
        
        for(int i = 0; i < n; i++) {
            for(int it : routes[i]) {
                adj.putIfAbsent(it, new HashSet<>());
                adj.get(it).add(i);
            }
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{source, 0});

        HashSet<Integer> seen = new HashSet<>();
        boolean[] seen_paths = new boolean[n];
        seen.add(source);

        while(!q.isEmpty()) {
            int[] t = q.remove();
            int stop = t[0], bus = t[1];

            if(stop == target) return bus;

            for(int i : adj.get(stop)) {
                if(seen_paths[i]) continue;
                for(int j : routes[i]) {
                    if(!seen.contains(j)) {
                        q.add(new int[]{j, bus + 1});
                        seen.add(j);
                    }
                } 
                seen_paths[i] = true;               
            }
        }

        return -1;
    }
}