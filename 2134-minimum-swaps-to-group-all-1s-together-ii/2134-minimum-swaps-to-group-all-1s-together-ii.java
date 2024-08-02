class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length, zeros = 0, l = 0, r = 0, ans = nums.length;
        int totalOnes = 0;

        for(int it : nums) if(it == 1) totalOnes++;

        if(totalOnes == 0) return 0;
        
        while(l < n) {
            if(nums[r % n] == 0) zeros++;

            if(r - l + 1 == totalOnes) {
                ans = Math.min(ans, zeros);
                if(nums[l++] == 0) zeros--;
            }

            r++;
        }

        return ans;
    }
}