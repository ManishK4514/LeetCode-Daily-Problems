class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length, idx = 0;

        int[] ans = new int[n];
        
        long[] prefix = new long[n];
        prefix[0] = nums[0];
        for(int i = 1; i < n; i++) prefix[i] = nums[i] + prefix[i - 1];
        
        for(int i = 0; i < n; i++){
            if(i >= k && n - i - 1 >= k){
                int l = i - k, r = i + k;
                long sum = l - 1 < 0 ? prefix[r] : prefix[r] - prefix[l - 1];
                ans[i] = (int)(sum / (2 * k + 1));
            }
            else ans[i] = -1;
        }

        return ans;
    }
}