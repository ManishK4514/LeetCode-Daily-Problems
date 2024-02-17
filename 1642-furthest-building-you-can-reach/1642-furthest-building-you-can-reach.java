class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n = heights.length, ans = 0, count = 1, sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
        
        for(int i = 1; i < n; i++) {
            if(heights[i] > heights[i - 1]) {
                pq.add(heights[i] - heights[i - 1]);
                while(pq.size() > ladders) {
                    sum += pq.remove();
                }

                if(sum > bricks) return i - 1;
            }
            ans = Math.max(ans, i);
        }

        return ans;
    }
}