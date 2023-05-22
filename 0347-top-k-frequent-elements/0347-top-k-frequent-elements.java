class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->{return b[1] - a[1];});
        for (int it : map.keySet()) {
            pq.add(new int[]{it, map.get(it)});
        }

        int[] res = new int[k];
        for(int i = 0; i < k; i++) res[i] = pq.remove()[0];
        return res;
    }
}