class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        int allvis = (1 << n) - 1;
        Queue<int[]> queue = new LinkedList<>();
        Set<Integer> vis = new HashSet<>();

        for (int i = 0; i < n; i++) {
            queue.offer(new int[]{1 << i, i, 0});
            vis.add((1 << i) * 16 + i);
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            if (cur[0] == allvis) {
                return cur[2];
            }

            for (int neighbor : graph[cur[1]]) {
                int newMask = cur[0] | (1 << neighbor);
                int hashValue = newMask * 16 + neighbor;

                if (!vis.contains(hashValue)) {
                    vis.add(hashValue);
                    queue.offer(new int[]{newMask, neighbor, cur[2] + 1});
                }
            }
        }

        return -1;
    }
}