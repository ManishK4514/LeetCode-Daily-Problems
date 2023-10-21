class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        int ans = nums[0], n = nums.length;
        Deque<Integer> dq = new LinkedList<>();
        
        for(int i = 0; i < n; i++) {
            nums[i] += (dq.isEmpty() ? 0 : dq.peek());
            ans = Math.max(ans, nums[i]);

            while(!dq.isEmpty() && dq.peekLast() < nums[i]) dq.removeLast();
            if(nums[i] > 0) dq.addLast(nums[i]);
            if(i >= k && !dq.isEmpty() && dq.peek() == nums[i - k]) {
                dq.removeFirst();
            }
        }

        return ans;
    }
}