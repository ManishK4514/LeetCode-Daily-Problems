class Solution {
    public long findMedian(int[] nums, int l, int r) {
        int n = r - l + 1;

        if (n % 2 == 0) {
            int left = nums[l + (n / 2) - 1];
            int right = nums[l + (n / 2)]; 
            return (left + right)/2;
        } 
        return nums[l + n / 2];
    }
    public long calculateCost(int[] nums, int l, int r, long[] prefix) {        
        long median = findMedian(nums, l, r);
        int len = r - l + 1, i = (r + l)/2;
        
        long leftSum = getSum(prefix, l, r, l, i);
        long rightSum = getSum(prefix, l, r, i + 1, r);
        long totalLeft = (i - l + 1) * median - leftSum;
        long totalRight = rightSum - (r - i) * median;
        return totalLeft + totalRight;
    }

    public long getSum(long[] prefix, int l, int r, int i, int j) {
        if(i == 0) return prefix[j];
        else return prefix[j] - prefix[i - 1];
    }

    public int maxFrequencyScore(int[] nums, long k) {
        Arrays.sort(nums);
        int n = nums.length, l = 0, r = 0, ans = 0;
        long[] prefix = new long[n];
        prefix[0] = nums[0];
        for(int i = 1; i < n; i++) {
            prefix[i] = nums[i];
            prefix[i] += prefix[i - 1];
        }

        while(r < n) {
            long cost = calculateCost(nums, l, r, prefix);

            while(cost > k && l < r) {
                l++;
                cost = calculateCost(nums, l, r, prefix);
            }

            ans = Math.max(ans, r - l + 1);

            r++;
        }
        
        return ans;
    }
}