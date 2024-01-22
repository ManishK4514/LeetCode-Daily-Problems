class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] map = new int[n + 1];
        for(int it : nums) map[it]++;

        int repeated = -1, missing = -1;

        for(int i = 1; i <= n; i++) {
            if(map[i] == 2) repeated = i;
            else if(missing == -1 && map[i] == 0) missing = i;
        }

        return new int[]{repeated, missing};
    }
}