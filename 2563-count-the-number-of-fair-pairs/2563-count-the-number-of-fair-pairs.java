class Solution {
    public int leftMostSearch(int[] nums, int target) {
        int l = 0, r = nums.length - 1; 

        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(nums[mid] >= target) r = mid - 1;
            else l = mid + 1;
        }

        return l;
    }

    public int rightMostSearch(int[] nums, int target) {
        int l = 0, r = nums.length - 1; 

        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(nums[mid] <= target) l = mid + 1;
            else r = mid - 1;
        }
        
        return r;
    }

    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        int n = nums.length;
        long ans = 0;

        for(int i = 0; i < n; i++) {
            long l = Math.max(i + 1, leftMostSearch(nums, lower - nums[i]));
            long r = rightMostSearch(nums, upper - nums[i]);
            if (l <= r) ans += (r - l + 1);
        }

        return ans;
    }
}
