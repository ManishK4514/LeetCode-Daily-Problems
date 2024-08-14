class Solution {
    public int countPairsWithinDistance(int[] nums, int target) {
        int pairs = 0, i = 0, n = nums.length;

        for(int j = 1; j < n; j++) {
            while(nums[j] - nums[i] > target) i++;
            pairs += j - i;
        }

        return pairs;
    }
    public int smallestDistancePair(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);

        int l = 0, r = nums[n - 1] - nums[0];
        while(l <= r) {
            int mid = l + (r - l)/2;
            int pairCount = countPairsWithinDistance(nums, mid);

            if(pairCount < k) {
                l = mid + 1;
            }
            else r = mid - 1; 
        }

        return l;
    }
}