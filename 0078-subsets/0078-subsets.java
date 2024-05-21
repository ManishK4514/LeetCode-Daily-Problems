class Solution {
    public void helper(int i, int[] nums, List<List<Integer>> subsets, List<Integer> subset) {
        if(i == nums.length) {
            subsets.add(new ArrayList<>(subset));
            return;
        }

        helper(i + 1, nums, subsets, subset);

        subset.add(nums[i]);
        helper(i + 1, nums, subsets, subset);
        subset.remove(subset.size() - 1);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new LinkedList<>();
        helper(0, nums, subsets, new LinkedList<>());
        return subsets;
    }
}