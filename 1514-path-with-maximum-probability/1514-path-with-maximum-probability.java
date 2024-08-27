class Pair{
    int first;
    double second;
    Pair(int first, double second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for(int i = 0; i < edges.length; i++){
            adj.get(edges[i][0]).add(new Pair(edges[i][1], succProb[i]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0], succProb[i]));
        }

        PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> Double.compare(b.second, a.second));

        q.add(new Pair(start, 1.0));
  
        double[] dist = new double[n];
        for(int i = 0; i < n; i++) dist[i] = -1e9;

        double ans = 0.0;
        dist[start] = 0.0;

        while(!q.isEmpty()){
            int node = q.peek().first;
            double dis = q.peek().second;
            q.remove();

            if(node == end) return dis;

            for(Pair it : adj.get(node)){
                int adjNode = it.first;
                double adjDist = dis * it.second;
                
                if(dist[adjNode] < adjDist){
                    dist[adjNode] = adjDist;
                    q.add(new Pair(adjNode, dist[adjNode]));
                }
            }
        }

        return ans;
    }
}