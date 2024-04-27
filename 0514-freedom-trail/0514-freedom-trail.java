class Solution {
    public int findRotateSteps(String ring, String key) {
        int n = ring.length(), m = key.length();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->{
            return a[2] - b[2];
        });

        HashSet<String> set = new HashSet<>();

        pq.add(new int[]{0, 0, 0});

        while(!pq.isEmpty()) {
            int[] top = pq.remove();
            int ringIdx = top[0];
            int keyIdx = top[1];
            int steps = top[2];

            if(ring.charAt(ringIdx) == key.charAt(keyIdx)) {
                steps++;
                if(keyIdx == m - 1) return steps;

                String curr = ringIdx + "#" + (keyIdx + 1);
                if(!set.contains(curr)) {
                    pq.add(new int[]{ringIdx, keyIdx + 1, steps});
                    set.add(curr);
                }                
            }
            else {
                // rotate clockwise
                String curr = ((ringIdx + 1) % n) + "#" + keyIdx;
                if(!set.contains(curr)) {
                    pq.add(new int[]{(ringIdx + 1) % n, keyIdx, steps + 1});
                    set.add(curr);
                } 

                // rotate anti clockwise
                curr = (((ringIdx - 1) + n) % n) + "#" + keyIdx;
                if (!set.contains(curr)) {
                    pq.add(new int[]{((ringIdx - 1) + n) % n, keyIdx, steps + 1});
                    set.add(curr);
                }
            }
        }

        return -1;
    }
}