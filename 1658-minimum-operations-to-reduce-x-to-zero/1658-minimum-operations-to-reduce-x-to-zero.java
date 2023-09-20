class Solution {
    public int longestSubarrayWithSumK(int[] nums, int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0, len = -1;
        map.put(0, -1);
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            map.put(sum, i);
            if(map.containsKey(sum - k)){
                len = Math.max(len, i - map.get(sum - k));
            }
        }
        if(len == -1) return -1;
        return nums.length - len;
    }
    public int minOperations(int[] nums, int x) {
        int totalSum = 0, n = nums.length;
        for(int it : nums) totalSum += it;

        int targetSum = totalSum - x;
        return longestSubarrayWithSumK(nums, targetSum);
    }
}