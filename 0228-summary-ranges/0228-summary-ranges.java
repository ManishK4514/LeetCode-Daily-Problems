class Solution {
    public List<String> summaryRanges(int[] nums) {
        ArrayList<String> ans = new ArrayList<>();
        if(nums.length == 0) return ans;
        int start = nums[0], end = nums[0] + 1, i = 1;
        for(i = 1; i < nums.length; i++){
            if(end != nums[i]){
                if(start == nums[i - 1]) ans.add(start + "");
                else ans.add(start+"->"+nums[i - 1]);
                start = nums[i];
                end = nums[i] + 1;
            }
            else end++;
        }

        if(start == nums[i - 1]) ans.add(start + "");
        else ans.add(start+"->"+nums[i - 1]);

        return ans;
    }
}