class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int l = 0, r = 0, n = nums.length, ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        while(r < n) {
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);

            while(map.get(nums[r]) > k) {
                map.put(nums[l], map.getOrDefault(nums[l], 0) - 1);
                l++;                
            }

            ans = Math.max(ans, r - l + 1);
            r++;
        }

        return ans;
    }
}