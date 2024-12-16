class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int n = nums.length;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)->{
            if(nums[a] == nums[b]) return a - b;
            return nums[a] - nums[b];
        });

        for(int i = 0; i < n; i++) pq.add(i);

        while(k-- > 0) {
            int idx = pq.remove();
            nums[idx] *=  multiplier;
            pq.add(idx);
        }

        return nums;
    }
}