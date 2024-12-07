class Solution {
    public boolean isPossible(int[] nums, int maxOperations, int target) {
        for(int num : nums) {
            if(num > target) {
                if(num % target == 0) {
                    maxOperations -= num/target;
                    maxOperations++;
                }
                else maxOperations -= num/target;
            }
        }
        return maxOperations >= 0;
    }
    public int minimumSize(int[] nums, int maxOperations) {
        int l = 1, r = (int)(1e9);
        while(l <= r) {
            int mid = l + (r - l)/2;
            if(isPossible(nums, maxOperations, mid)) r = mid - 1;
            else l = mid + 1;
        }
        return l;
    }
}