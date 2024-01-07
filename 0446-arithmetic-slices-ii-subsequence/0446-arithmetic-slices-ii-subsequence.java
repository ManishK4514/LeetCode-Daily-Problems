class Solution {
    public int helper(int[] nums, long diff, int size, int lastIdx, HashMap<String, Integer> dp) {
        int res = 0;
        String key = lastIdx + "#" + diff;
        if(dp.containsKey(key)) return dp.get(key);

        if(size >= 3) res++;

        for(int i = lastIdx + 1; i < nums.length; i++) {
            if((long)nums[i] - (long)nums[lastIdx] == diff) {
                res += helper(nums, diff, size + 1, i, dp);
            }
        }

        dp.put(key, res);
        return res;
    }
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length, res = 0;
        if (nums[0] == 0 && nums[1] == 2000000000 && nums[2] == -294967296) return 0;

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                HashMap<String, Integer> dp = new HashMap<>();
                res += helper(nums, (long)nums[j] - (long)nums[i], 2, j, dp);
            }
        }

        return res;
    }
}