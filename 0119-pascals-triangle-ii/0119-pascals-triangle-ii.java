class Solution {
    public List<Integer> getRow(int numRows) {
        int[] prev = new int[numRows + 1];
        int[] curr = new int[numRows + 1];
        prev[0] = 1;
        int prevLen = 1;
        for(int i = 1; i <= numRows + 1; i++) {
            int k = 0;
            curr[k++] = 1;
            for(int j = 0; j < prevLen - 1; j++) {
                curr[k++] = prev[j] + prev[j + 1];
            }
            prevLen++;
            prev = curr.clone();
        }
        List<Integer> res = new ArrayList<>();
        for (int num : prev) res.add(num);
        return res;
    }
}