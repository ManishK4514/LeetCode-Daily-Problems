class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)->b-a);
        for(int gift : gifts) pq.add(gift);

        long ans = 0;

        while(k-->0) {
            int curr = pq.remove();
            curr = (int)Math.sqrt(curr);
            pq.add(curr);
        }

        while(!pq.isEmpty()) ans += (long) pq.remove();

        return ans;
    }
}