class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for(char ch : tasks) map[ch - 'A']++;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)->{
            return map[b] - map[a];
        });

        for(int i = 0; i < 26; i++) {
            if(map[i] > 0) pq.add(i);
        }

        int intervals = 0;

        int[] lastOccurence = new int[26];
        Arrays.fill(lastOccurence, -1);

        while(!pq.isEmpty()) {
            ArrayList<Integer> ls = new ArrayList<>();
            boolean idle = true;
            while(!pq.isEmpty()) {
                int curr = pq.remove();
                if(lastOccurence[curr] == -1 || lastOccurence[curr] < intervals - n) {
                    lastOccurence[curr] = intervals;
                    intervals++;
                    map[curr]--;
                    ls.add(curr);
                    idle = false;
                    break;
                }
                ls.add(curr);
            }

            for(int it : ls) {
                if(map[it] > 0) pq.add(it);
            }

            if(idle) intervals++;
        }

        return intervals;
    }
}