class Solution {
    public int minGroups(int[][] intervals) {
        int[] map = new int[(int)(1e6 + 2)];
        int n = intervals.length;
        for(int i = 0; i < n; i++) {
            map[intervals[i][0]]++;
            map[intervals[i][1] + 1]--;
        }

        int ans = 0;

        for(int i = 0; i < map.length; i++) {
            map[i] += i == 0 ? 0 : map[i - 1];
            ans = Math.max(map[i], ans);
        }

        return ans;
    }
}