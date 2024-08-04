class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int[] arr = new int[n * (n + 1) / 2];
        int idx = 0;

        for(int i = 0; i < n; i++) {
            int sum = 0;
            for(int j = i; j < n; j++) {
                sum += nums[j];
                arr[idx++] = sum;
            }
        }

        Arrays.sort(arr);

        long ans = 0;        
        for(int i = left - 1; i <= Math.min(right - 1, (n * (n + 1) / 2) - 1); i++) ans += (long)arr[i];

        return (int)(ans % (long)(1e9 + 7));
    }
}