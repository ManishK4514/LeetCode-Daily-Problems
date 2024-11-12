class Solution {
    public int helper(int[][] items, int target) {
        int l = 0, r = items.length - 1;

        while(l <= r) {
            int mid = l + (r - l)/2;

            if(items[mid][0] <= target) l = mid + 1;
            else r = mid - 1;
        }

        return r == -1 ? 0 : items[r][1];
    }

    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, (a, b)->{
            if(a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });

        for (int i = 1; i < items.length; i++) {
            items[i][1] = Math.max(items[i][1], items[i - 1][1]);
        }

        int n = queries.length;
        int[] ans = new int[n];
        
        for(int i = 0; i < n; i++) ans[i] = helper(items, queries[i]);
        return ans;
    }
}