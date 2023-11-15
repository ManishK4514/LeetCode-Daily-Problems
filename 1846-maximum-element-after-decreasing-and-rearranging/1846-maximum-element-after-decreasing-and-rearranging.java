class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {        
        Arrays.sort(arr);
        int n = arr.length, max = 1;
        arr[0] = 1;

        for(int i = 1; i < n; i++) {
            if(arr[i] - arr[i - 1] > 1) arr[i] = arr[i - 1] + 1;

            max = Math.max(max, arr[i]);
        }

        return max;
    }
}