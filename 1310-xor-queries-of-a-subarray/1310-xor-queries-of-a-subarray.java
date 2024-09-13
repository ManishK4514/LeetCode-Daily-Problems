class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int m = queries.length, idx = 0, n = arr.length;
        int[] ans = new int[m];

        int[] suffix = new int[n];
        int[] prefix = new int[n];

        int suffXor = 0, preXor = 0;

        for(int i = 0; i < n; i++) {
            preXor ^= arr[i];
            suffXor ^= arr[n - i - 1];

            prefix[i] = preXor;
            suffix[n - i - 1] = suffXor;
        }

        for(int[] query : queries) {
            int i = query[0], j = query[1];

            preXor = i == 0 ? 0 : prefix[i - 1];
            suffXor = j == n - 1 ? 0 : suffix[j + 1];
            
            ans[idx++] = preXor ^ suffXor ^ prefix[n - 1];
        }

        return ans;
    }
}