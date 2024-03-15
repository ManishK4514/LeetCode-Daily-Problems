class Solution {
    public int[] productExceptSelf(int[] nums) {
        int p = 1, n = nums.length;

        int[] suffix = new int[n];
        for(int i = n - 1; i >= 0; i--) {
            p *= nums[i];
            suffix[i] = p;
        }

        p = 1;
        int[] res = new int[n];

        for(int i = 0; i < n; i++) {
            if(i == n - 1) res[i] = p;
            else {
                res[i] = p * suffix[i + 1];
                p *= nums[i];
            }
        }

        return res;
    }
}