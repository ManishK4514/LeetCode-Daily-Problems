class Solution {
    public int getWinner(int[] arr, int k) {
        int n = arr.length, curr = arr[0], count = 0;
        for(int i = 0; i < n; i++){
            if(arr[i] < curr) count++;
            else if(arr[i] > curr){
                count = 0;
                curr = arr[i];
                if(arr[i - 1] < arr[i]) count++;
            }
            if(count == k) return curr;
        }
        return curr;
    }
}