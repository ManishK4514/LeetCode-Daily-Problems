class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        List<List<Double>> ans = new ArrayList<>();
        ans.add(Arrays.asList(poured * 1D));

        for(int i = 0; i <= query_row; i++) {
            List<Double> curr = ans.get(i);
            List<Double> next = new ArrayList<>();
            
            for(int j = 0; j < curr.size() + 1; j++) next.add(0.0);
            for(int j = 0; j < curr.size(); j++) {
                if(curr.get(j) > 1) {
                    double val = curr.get(j) - 1;
                    curr.set(j, 1.0);
                    next.set(j, next.get(j) + (val/2));
                    next.set(j + 1, next.get(j + 1) + (val/2));
                }
            }            
            ans.add(next);
        }

        return ans.get(query_row).get(query_glass);
    }
}