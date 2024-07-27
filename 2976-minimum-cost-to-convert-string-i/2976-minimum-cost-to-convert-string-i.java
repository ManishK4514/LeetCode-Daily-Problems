class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int n = 26; 
        long[][] dist = new long[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Long.MAX_VALUE);
            dist[i][i] = 0;
        }

        for (int i = 0; i < original.length; i++) {
            int u = original[i] - 'a';
            int v = changed[i] - 'a';
            dist[u][v] = Math.min(dist[u][v], (long) cost[i]);
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] != Long.MAX_VALUE && dist[k][j] != Long.MAX_VALUE) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        long ans = 0;

        for (int i = 0; i < source.length(); i++) {
            char src = source.charAt(i);
            char dst = target.charAt(i);

            int u = src - 'a';
            int v = dst - 'a';

            if (dist[u][v] == Long.MAX_VALUE) {
                return -1; 
            }

            ans += dist[u][v];
        }

        return ans;
    }
}