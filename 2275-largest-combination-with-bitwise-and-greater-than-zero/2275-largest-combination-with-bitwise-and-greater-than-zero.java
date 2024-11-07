class Solution {
    public int largestCombination(int[] candidates) {
        int[] map = new int[25];
        int ans = 0;

        for(int i = 0; i < candidates.length; i++) {
            for(int j = 0; j < 25; j++) {
                if((candidates[i] & (1 << j)) >= 1) {
                    map[j]++;
                    ans = Math.max(ans, map[j]);
                }
            }
        }

        return ans;
    }
}