class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int n = groupSizes.length;
        for(int i = 0; i < n; i++) {
            map.putIfAbsent(groupSizes[i], new LinkedList<>());
            map.get(groupSizes[i]).add(i);
        }

        List<List<Integer>> groups = new LinkedList<>();

        for(int key : map.keySet()) {
            List<Integer> curr = map.get(key);
            int i = 0, m = curr.size();
            while(i < m) {
                List<Integer> group = new LinkedList<>();
                for(int j = i; j < i + key; j++) {
                    group.add(curr.get(j));
                }
                i += key;
                groups.add(group);
            }
        }

        return groups;
    }
}