class Solution {
    public int findSpecialInteger(int[] arr) {
        int n = arr.length, required = arr.length/4, cnt = 1;
        for(int i = 1; i < n; i++) {
            if(arr[i] == arr[i - 1]) cnt++;
            else {
                if(cnt > required) return arr[i - 1];
                cnt = 1;
            }
        }
        return cnt > required ? arr[n - 1] : -1;
    }
}