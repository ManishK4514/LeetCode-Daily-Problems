class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {          
        int len = nums.size(), maxColLen = 0;  
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[0] == b[0] ? b[1] - a[1] : a[0] - b[0];
        });
        
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < nums.get(i).size(); j++) {
                pq.add(new int[]{i + j, i, nums.get(i).get(j)});
            }
        }

        int[] ans = new int[pq.size()];
        int idx = 0;

        while(!pq.isEmpty()) ans[idx++] = pq.remove()[2];

        return ans;
    }
}