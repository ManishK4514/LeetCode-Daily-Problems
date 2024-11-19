class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long sum = 0, maxSum = 0;
        int l = 0, r = 0, n = nums.length;

        HashMap<Integer, Integer> map = new HashMap<>();

        while(r < n) {
            sum += nums[r];
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            if(r - l + 1 > k) {
                sum -= nums[l];
                map.put(nums[l], map.getOrDefault(nums[l], 0) - 1);
                if(map.get(nums[l]) == 0) map.remove(nums[l]);
                l++;
            }
            if(map.size() == k) maxSum = Math.max(maxSum, sum);
            r++;
        }

        return maxSum;
    }
}