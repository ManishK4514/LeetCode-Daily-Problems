class Pair{
    int distance;
    int node;
    Pair(int distance, int node){        
        this.distance = distance;
        this.node = node;
    }
}
class Solution {
    public int minScore(int n, int[][] roads) {  
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++) adj.add(new ArrayList<>());
        for(int i = 0; i < roads.length; i++){
            adj.get(roads[i][0]).add(new Pair(roads[i][2], roads[i][1]));
            adj.get(roads[i][1]).add(new Pair(roads[i][2], roads[i][0]));
        }
        Queue<Pair> pq = new LinkedList<>();
        int[] dist = new int[n + 1];
        for(int i = 0; i < n + 1; i++) dist[i] = (int)(1e9);
        int ans = Integer.MAX_VALUE;
        pq.add(new Pair(0, 1));
        while(!pq.isEmpty()){
            int node = pq.peek().node;
            int wt = pq.peek().distance;
            pq.remove();
            for(Pair it : adj.get(node)){
                int adjNode = it.node;
                int adjWt = it.distance;
                ans = Math.min(ans, adjWt);
                if(adjWt + wt < dist[adjNode]){                    
                    dist[adjNode] = adjWt + wt;
                    pq.add(new Pair(adjWt + wt, adjNode));
                }
            }
        }
        // System.out.println(Arrays.toString(dist));
        return dist[n] == 1e9 ? -1 : ans;
    }
}