class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        
        for (int num : nums) pq.add(num);
        long ans = 0;

        while (k-- > 0) {
            int num = pq.remove();
            ans += num;
            pq.add((int) Math.ceil(num / 3.0));
        }

        return ans;
    }
}
