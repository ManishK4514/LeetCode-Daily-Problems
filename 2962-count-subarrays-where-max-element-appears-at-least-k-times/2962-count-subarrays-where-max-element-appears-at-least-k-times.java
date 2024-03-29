class Solution {
    public long countSubarrays(int[] nums, int k) {
        int max = -1, l = 0, r = 0, n = nums.length, currMaxFreq = 0;
        for(int it : nums) max = Math.max(max, it);
        long count = 0;
        
        while(r < n) {
            if(nums[r] == max) currMaxFreq++;

            while(currMaxFreq >= k) {
                if(nums[l] == max) currMaxFreq--;
                count += n - r;
                l++;
            }

            r++;
        }

        return count;
    }
}