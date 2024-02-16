class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        int n = arr.length;

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int it : arr) map.put(it, map.getOrDefault(it, 0) + 1);

        PriorityQueue<Integer> pq = new PriorityQueue((a, b)->{
            return map.get(a) - map.get(b);
        });
        for(int it : map.keySet()) pq.add(it);

        while(!pq.isEmpty()) {
            int key = pq.peek();
            int freq = map.get(key);
            if(freq <= k) {
                k -= freq;
                pq.remove();
            }
            else break;
        }

        return pq.size();
    }
}