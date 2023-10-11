class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for(int[] flower : flowers) {
            map.put(flower[0], map.getOrDefault(flower[0], 0) + 1);
            map.put(flower[1] + 1, map.getOrDefault(flower[1] + 1, 0) - 1);
        }

        int sum = 0, n = people.length;

        for(int key : map.keySet()) {
            sum += map.get(key);
            map.put(key, sum);
        }

        int[] res = new int[n];

        for(int i = 0; i < n; i++) {
            Integer key = map.floorKey(people[i]);
            if(key != null) res[i] = map.get(key);
        }

        return res;
    }
}