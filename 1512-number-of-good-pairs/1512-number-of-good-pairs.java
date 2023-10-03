class Solution {
    public int numIdenticalPairs(int[] nums) {
        int ans = 0, n = nums.length;
        int[] freq = new int[101];
        for(int it : nums) ans += freq[it]++;
        return ans;
    }
}