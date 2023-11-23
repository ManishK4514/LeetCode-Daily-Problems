class Solution {
    public boolean helper(int[] nums, int l, int r) {
        int[] arr = new int[r - l + 1];
        int idx = 0, len = r - l + 1;
        while(l <= r) arr[idx++] = nums[l++];

        Arrays.sort(arr);        
        int diff = arr[1] - arr[0];

        for(int i = 2; i < len; i++) {
            if(arr[i] - arr[i - 1] != diff) return false;
        }

        return true;
    }
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int m = l.length;
        List<Boolean> ans = new ArrayList<>();

        for(int i = 0; i < m; i++) {
            ans.add(helper(nums, l[i], r[i]));
        }

        return ans;
    }
}