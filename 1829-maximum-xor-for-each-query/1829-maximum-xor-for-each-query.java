class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length, xor = 0;
        int[] ans = new int[n];
         
        for(int i = 0; i < n; i++) {
            xor ^= nums[i];
            
            int curr = 0;
            for(int j = 0; j < maximumBit; j++) {
                if ((xor & (1 << j)) == 0) curr |= (1 << j);  
            }

            ans[n - i - 1] = curr;
        }

        return ans;
    }
}