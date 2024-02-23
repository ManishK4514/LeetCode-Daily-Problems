class Tuple {
    int node;
    int dist;
    int stops;

    Tuple(int node, int dist, int stops) {
        this.node = node;
        this.dist = dist;
        this.stops = stops;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int[] flight : flights) {
            adj.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }

        int[] distance = new int[n];
        Arrays.fill(distance, (int)(1e9));

        Queue<Tuple> pq = new LinkedList<>();

        pq.add(new Tuple(src, 0, 0));
        distance[src] = 0;

        while(!pq.isEmpty()) {
            Tuple t = pq.remove();
            int node = t.node;
            int dist = t.dist;
            int stops = t.stops;

            for(int[] it : adj.get(node)) {
                int currNode = it[0];
                int currDist = dist + it[1];

                if(distance[currNode] > currDist && stops <= k) {
                    distance[currNode] = currDist;
                    pq.add(new Tuple(currNode, currDist, stops + 1));
                }
            }
        }

        return distance[dst] == (int)(1e9) ? -1 : distance[dst];
    }
}