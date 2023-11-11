class Pair {
    int node;
    int dist;
    Pair(int node, int dist) {
        this.node = node;
        this.dist = dist;
    }
}

class Graph {
    ArrayList<ArrayList<Pair>> adj;
    int n;
    public Graph(int n, int[][] edges) {
        adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        this.n = n;

        for(int[] edge : edges) {
            adj.get(edge[0]).add(new Pair(edge[1], edge[2]));
        }
    }
    
    public void addEdge(int[] edge) {
        adj.get(edge[0]).add(new Pair(edge[1], edge[2]));
    }
    
    public int shortestPath(int src, int dst) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b)->{
            return a.dist - b.dist;
        }); 

        int[] distance = new int[n];
        for(int i = 0; i < n; i++) distance[i] = (int)(1e9); 

        pq.add(new Pair(src, 0));
        distance[src] = 0;

        while(!pq.isEmpty()) {
            Pair p = pq.remove();
            int node = p.node;
            int dist = p.dist;

            if(node == dst) return dist;

            for(Pair it : adj.get(node)) {
                int adjNode = it.node;
                int currDst = dist + it.dist;

                if(distance[adjNode] > currDst) {
                    distance[adjNode] = currDst;
                    pq.add(new Pair(adjNode, dist + it.dist));
                }
            }
        }

        return -1;
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */