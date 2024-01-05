class Solution {
    public int lowerBound(ArrayList<Integer> list, int target){
        int l = 0, h = list.size() - 1;
        while(l <= h){
            int mid = l + (h - l)/2;
            if(list.get(mid) >= target) h = mid - 1;
            else l = mid + 1;
        }
        return l;
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(nums[0]);

        for(int i = 1; i < n; i++){
            if(temp.get(temp.size() - 1) < nums[i]){
                temp.add(nums[i]);
            }
            else {
                int idx = lowerBound(temp, nums[i]);
                temp.set(idx, nums[i]);
            }
        }

        return temp.size();
    }
}