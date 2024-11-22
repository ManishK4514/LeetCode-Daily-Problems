class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> count = new HashMap<>();
        
        for (int[] row : matrix) {
            StringBuilder key = new StringBuilder();
            
            if (row[0] == 1) {
                for (int n : row) key.append(n == 0 ? 1 : 0);
            } else {
                for (int n : row) key.append(n);
            }
            
            count.merge(key.toString(), 1, Integer::sum);
        }
        
        return Collections.max(count.values());
    }
}