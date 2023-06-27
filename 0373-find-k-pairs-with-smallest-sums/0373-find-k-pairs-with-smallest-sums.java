class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Pair<Integer, Pair<Integer, Integer>>> pq = new PriorityQueue<>((a, b) -> b.getKey() - a.getKey());
        
        int n = nums1.length;
        int m = nums2.length;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                int sum = nums1[i] + nums2[j];

                if(pq.size() < k){
                    pq.add(new Pair<>(sum, new Pair<>(nums1[i], nums2[j])));
                }
                else if(sum < pq.peek().getKey()){
                    pq.remove();
                    pq.add(new Pair<>(sum, new Pair<>(nums1[i], nums2[j])));
                }
                else break;
            }
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        while(!pq.isEmpty()){
            Pair<Integer, Integer> p = pq.poll().getValue();
            List<Integer> pairList = new ArrayList<>();
            pairList.add(p.getKey());
            pairList.add(p.getValue());
            ans.add(pairList);
        }

        return ans;
    }
}