class Pair{
    int first;
    int second;
    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
class Touple{
    int first;
    int second;
    int third;
    Touple(int first, int second, int third){
        this.first = first;
        this.second = second;
        this.third = third;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<Pair>());
        }
        for(int i = 0; i < flights.length; i++){
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }
        int[] dist = new int[n];
        for(int i = 0; i < n; i++) dist[i] = Integer.MAX_VALUE;
        Queue<Touple> q = new LinkedList<>();
        q.add(new Touple(0, src, 0));
        while(!q.isEmpty()){
            Touple it = q.remove();
            int stops = it.first;
            int node = it.second;
            int cost = it.third;

            if(stops > k) continue;
            for(Pair iter : adj.get(node)){
                int adjNode = iter.first;
                int edgeWeight = iter.second;
                if(cost + edgeWeight < dist[adjNode]){
                    dist[adjNode] = cost + edgeWeight;
                    q.add(new Touple(stops + 1, adjNode, dist[adjNode]));
                }
            }
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}