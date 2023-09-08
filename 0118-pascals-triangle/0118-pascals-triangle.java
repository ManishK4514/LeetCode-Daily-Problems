class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(Arrays.asList(1));
        for(int i = 2; i <= numRows; i++) {
            List<Integer> curr = new ArrayList<>();
            curr.add(1);
            List<Integer> prevRow = ans.get(ans.size() - 1);
            for(int j = 0; j < prevRow.size() - 1; j++) {
                curr.add(prevRow.get(j) + prevRow.get(j + 1));
            }
            curr.add(1);
            ans.add(curr);
        }
        return ans;
    }
}