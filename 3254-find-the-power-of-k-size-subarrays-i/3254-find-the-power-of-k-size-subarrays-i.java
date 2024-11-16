class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length, l = 0, r = 0, prev = 0, idx = 0, max = 0;
        int[] ans = new int[n - k + 1];

        while(r < n) {
            max = Math.max(max, nums[r]);
            if(prev != nums[r] - 1) {
                l = r;
                max = nums[r];
            }

            if(r - l + 1 == k) {
                ans[idx] = nums[r];
                l++;
            }
            
            prev = nums[r];
            r++;
            if(r >= k) idx++;
        }

        for(int i = 0; i < ans.length; i++) {
            if(ans[i] == 0) ans[i] = -1;
        }

        return ans;
    }
}