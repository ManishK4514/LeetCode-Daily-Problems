class Solution {
    public boolean possible(int[] nums, int p, int diff){
        for(int i = 1; i < nums.length; i++){
            if(nums[i] - nums[i - 1] <= diff){
                p--; i++;
            }
        }
        return p <= 0;
    }
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int l = 0, r = nums[nums.length - 1] - nums[0];
        while(l <= r){
            int mid = l + (r - l)/2;
            if(possible(nums, p, mid)) r = mid - 1;
            else l = mid + 1;
        }
        return l;
    }
}