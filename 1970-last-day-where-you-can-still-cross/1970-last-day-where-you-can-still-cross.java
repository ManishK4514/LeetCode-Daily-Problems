class Solution {
    public boolean helper(int row, int col, int n, int m, int day, HashMap<String, Integer> map, int[][] vis) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{row, col});

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];

            if (r == n - 1) return true;

            for (int i = 0; i < 4; i++) {
                int nrow = r + delRow[i];
                int ncol = c + delCol[i];
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0) {
                    String key = nrow + "#" + ncol;
                    if (!map.containsKey(key) || map.get(key) > day) {
                        vis[nrow][ncol] = 1;
                        q.add(new int[]{nrow, ncol});
                    }
                }
            }
        }
        return false;
    }

    public boolean possible(int n, int m, int day, HashMap<String, Integer> map) {
        int[][] vis = new int[n][m];

        for (int j = 0; j < m; j++) {
            if (map.containsKey("0#" + j) && map.get("0#" + j) <= day) continue;
            if (helper(0, j, n, m, day, map, vis)) return true;
        }
        return false;
    }

    public int latestDayToCross(int n, int m, int[][] cells) {
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < cells.length; i++) {
            map.put((cells[i][0] - 1) + "#" + (cells[i][1] - 1), i);
        }

        int l = 0, r = cells.length - 1;
        int[][] vis = new int[n][m];
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (possible(n, m, mid, map)) l = mid + 1;
            else r = mid;
        }
        return l;
    }
}
