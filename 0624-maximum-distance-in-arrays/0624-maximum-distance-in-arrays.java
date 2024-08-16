class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int min = arrays.get(0).get(0);
        int ans = 0, n = arrays.size();

        int[] suffix = new int[n];
        Arrays.fill(suffix, (int)(1e9));
        suffix[n - 1] = arrays.get(n - 1).get(0);

        for(int i = n - 2; i >= 0; i--) {
            List<Integer> nums = arrays.get(i);
            suffix[i] = Math.min(nums.get(0), suffix[i + 1]);            
        } 

        for(int i = 0; i < n; i++) {
            int max = arrays.get(i).get(arrays.get(i).size() - 1);

            if(i > 0 && i < n - 1) {
                int currMin = Math.min(min, suffix[i + 1]);
                ans = Math.max(Math.abs(max - currMin), ans);
            }
            else if(i == 0){
                int currMin = suffix[i + 1];
                ans = Math.max(Math.abs(max - currMin), ans);
            }
            else {
               int currMin = min;
                ans = Math.max(Math.abs(max - currMin), ans);
            }       

            min = Math.min(min, arrays.get(i).get(0));
        }

        return ans;
    }
}