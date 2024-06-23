class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int n = nums.length, ans = 0, l = 0, r = 0;
        
        Deque<Integer> max = new LinkedList<>();
        Deque<Integer> min = new LinkedList<>();

        while(r < n) {
            while(!max.isEmpty() && nums[max.peekLast()] < nums[r]) {
                max.removeLast();
            }

            while(!min.isEmpty() && nums[min.peekLast()] > nums[r]) {
                min.removeLast();
            }

            max.addLast(r);
            min.addLast(r);

            int maxValue = nums[max.peekFirst()];
            int minValue = nums[min.peekFirst()];

            while(maxValue - minValue > limit) {
                if(!max.isEmpty() && max.peekFirst() == l) max.removeFirst();
                if(!min.isEmpty() && min.peekFirst() == l) min.removeFirst();

                if(!max.isEmpty()) maxValue = nums[max.peekFirst()];
                if(!min.isEmpty()) minValue = nums[min.peekFirst()];
                l++;
            }

            ans = Math.max(ans, r - l + 1);
            r++;
        }

        return ans;
    }
}