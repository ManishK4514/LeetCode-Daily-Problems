class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        int freq[] = new int[nums.length + 1];

        ArrayList<List<Integer>> ans = new ArrayList<>();
        for (int it : nums) {
            if (freq[it] >= ans.size()) {
                ans.add(new ArrayList<>());
            }
            ans.get(freq[it]).add(it);
            freq[it]++;
        }

        return ans;
    }
}