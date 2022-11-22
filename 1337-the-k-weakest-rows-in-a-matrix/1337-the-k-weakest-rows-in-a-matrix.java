class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] != b[0]? b[0] - a[0] : b[1] - a[1]);
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < mat.length; i++){
            int sol = 0;
            for(int j = 0; j < mat[i].length; j++){
                if(mat[i][j] == 1){
                    sol++;
                }
                else{
                    break;
                }
            }
            pq.add(new int[]{sol, i});
        }
        int[] res = new int[k];
        while(pq.size() > k){
            pq.poll();
        }
        while(k > 0){
            res[--k] = pq.poll()[1];
        }
        return res;
    }
}