class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int n = nums.length;
        int[][] arr = new int[n][2];

        for(int i = 0; i < n; i++) {
            String num = nums[i] + "";
            int val = 0;
            for(int j = 0; j < num.length(); j++) {
                int d = num.charAt(j) - '0';
                val = val * 10 + mapping[d];
            }
            arr[i] = new int[]{i, val};
        }

        Arrays.sort(arr, (a, b)->{
            if(a[1] == b[1]) return a[0] - b[0];
            return a[1] - b[1];
        });

        int[] ans = new int[n];
        for(int i = 0; i < n; i++) {
            ans[i] = nums[arr[i][0]];
        }

        return ans;
    }
}