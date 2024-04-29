class Solution {
    public int minOperations(int[] nums, int k) {
        int n = nums.length, ans = 0, xor = 0;

        for(int i = 0; i < n; i++) xor ^= nums[i];
        
        for(int i = 0; i < 32; i++) {
            if((k & (1 << i)) >= 1) {
                if((xor & (1 << i)) == 0) ans++;
            }
            else {
                if((xor & (1 << i)) >= 1) ans++;
            }
        }

        return ans;
    }
}
