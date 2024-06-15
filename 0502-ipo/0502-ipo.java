class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int[][] nums = new int[n][2];

        for(int i = 0; i < n; i++) {
            nums[i] = new int[]{profits[i], capital[i]};
        }

        Arrays.sort(nums, (a, b)->{
            return a[1] - b[1];
        });

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->{
            return b[0] - a[0];
        });

        int i = 0;

        while(k-->0) {
            while(i < n && nums[i][1] <= w) {
                pq.add(nums[i]);
                i++;
            } 
            if(!pq.isEmpty()) {
                int[] curr = pq.remove();
                w += curr[0];
            }
        }
        
        return w;
    }
}