class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for(int it : nums) set.add(it);

        int m = set.size(), idx = 0, ans = n, j = 0;
        int[] uniqueNums = new int[set.size()];
        for(int it : set) uniqueNums[idx++] = it;

        Arrays.sort(uniqueNums);

        for(int i = 0; i < m; i++) {
            while(j < m && uniqueNums[j] <= uniqueNums[i] + n - 1) j++;
            ans = Math.min(ans, n - (j - i));
        }

        return ans;
    }
}