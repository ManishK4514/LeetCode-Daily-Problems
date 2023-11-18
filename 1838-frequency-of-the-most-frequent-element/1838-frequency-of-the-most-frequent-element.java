class Solution {
    public int maxFrequency(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);

        int[] prefix = new int[n];
        prefix[0] = nums[0];

        for(int i = 1; i < n; i++) {
            prefix[i] = nums[i];
            prefix[i] += prefix[i - 1];
        }

        int l = 0, r = 1, ans = 1;

        while(r < n) {
            int currCost = nums[r] * (r - l + 1) - (prefix[r] - (l - 1 < 0 ? 0 : prefix[l - 1]));

            while(currCost > k) {
                l++;
                currCost = nums[r] * (r - l + 1) - (prefix[r] - (l - 1 < 0 ? 0 : prefix[l - 1]));
            }

            ans = Math.max(ans, r - l + 1);
            r++;
        }

        return ans;
    }
}