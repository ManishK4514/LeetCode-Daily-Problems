class Solution {
    HashSet<ArrayList<Integer>> set = new HashSet<>();
    public void helper(int idx, int[] nums, ArrayList<Integer> ds){
        if(idx == nums.length){
            if(ds.size() >= 2) set.add(new ArrayList<>(ds));
            return;
        }
        int curr = nums[idx], prev = ds.size() == 0 ? -101 : ds.get(ds.size() - 1);
        if(curr >= prev){
            // pick
            ds.add(nums[idx]);
            helper(idx + 1, nums, ds);
            ds.remove(ds.size() - 1);
        }
        // not pick
        helper(idx + 1, nums, ds);
    }
    public List<List<Integer>> findSubsequences(int[] nums) {        
        helper(0, nums, new ArrayList<>());     
        List<List<Integer>> res = new ArrayList<>(set);   
        return res;
    }
}