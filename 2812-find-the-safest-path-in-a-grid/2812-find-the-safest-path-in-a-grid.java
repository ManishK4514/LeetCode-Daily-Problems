class Solution {
    public boolean bfs(int[][] grid, int[] delRow, int[] delCol, int target) {
        if(grid[0][0] < target) return false; 

        int n = grid.length;
        int[][] vis = new int[n][n];
        Queue<int[]> queue = new LinkedList<>();
    
        queue.offer(new int[]{0, 0});
        vis[0][0] = 1;
    
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
    
            if (row == n - 1 && col == n - 1) {
                return true;
            }
    
            for (int i = 0; i < 4; i++) {
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];
    
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < n && vis[nrow][ncol] == 0 && grid[nrow][ncol] >= target) {
                    queue.offer(new int[]{nrow, ncol});
                    vis[nrow][ncol] = 1;
                }
            }
        }
    
        return false;
    }

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        if(grid.get(0).get(0) == 1) return 0;

        int n = grid.size();
        int[][] matrix = new int[n][n];

        for(int[] it : matrix) Arrays.fill(it, -1);

        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(grid.get(i).get(j) == 1) {
                    q.add(new int[]{i, j, 0});
                    matrix[i][j] = 0;
                }
            }
        }

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        while(!q.isEmpty()) {
            int[] peek = q.remove();
            int row = peek[0];
            int col = peek[1];
            int dist = peek[2];

            for(int i = 0; i < 4; i++) {
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];
    
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < n && matrix[nrow][ncol] == -1) {
                    matrix[nrow][ncol] = dist + 1;
                    q.add(new int[]{nrow, ncol, dist + 1});
                }
            }
        }

        int l = 0, r = (int)(1e9);

        while(l <= r) {
            int mid = l + (r - l)/2;
            int[][] vis = new int[n][n];

            if(bfs(matrix, delRow, delCol, mid)) l = mid + 1;
            else r = mid - 1;
        }

        return r;
    }
}