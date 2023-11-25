class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for(int i = 1; i < n; i++) prefix[i] = nums[i] + prefix[i - 1];
        
        int[] res = new int[n];

        for(int i = 0; i < n; i++) {
            int leftSum = (i == 0) ? 0 : (nums[i] * i) - prefix[i - 1];
            int rightSum = (i == n - 1) ? 0 : (prefix[n - 1] - prefix[i]) - ((n - i - 1) * nums[i]);

            res[i] = leftSum + rightSum;
        }
        
        return res;
    }
}