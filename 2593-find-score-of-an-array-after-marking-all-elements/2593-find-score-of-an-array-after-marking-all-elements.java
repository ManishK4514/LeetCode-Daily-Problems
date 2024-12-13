class Solution {
    public long findScore(int[] nums) {
        int n = nums.length;
        int[] marked = new int[n];

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)->{
            if(nums[a] == nums[b]) return a - b;
            return nums[a] - nums[b];
        });

        for(int i = 0; i < n; i++) pq.add(i);

        long score = 0;

        while(!pq.isEmpty()) {            
            int idx = pq.remove();
            if(marked[idx] == 1) continue;
            score += nums[idx];
            marked[idx] = 1;
            if(idx - 1 >= 0) marked[idx - 1] = 1;
            if(idx + 1 < n) marked[idx + 1] = 1;
        }

        return score;
    }
}