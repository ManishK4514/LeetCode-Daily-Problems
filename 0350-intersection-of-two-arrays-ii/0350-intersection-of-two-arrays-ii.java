class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int it : nums1) map.put(it, map.getOrDefault(it, 0) + 1);

        List<Integer> ls = new ArrayList<>();

        for(int it : nums2) {
            if(map.containsKey(it)) {
                ls.add(it);
                map.put(it, map.getOrDefault(it, 0) - 1);
                if(map.get(it) == 0) map.remove(it);
            }
        }

        int idx = 0;

        int[] ans = new int[ls.size()];
        for(int it : ls) ans[idx++] = it;
        return ans;
    }
}