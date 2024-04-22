class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> deads = new HashSet<>(Arrays.asList(deadends));
        
        Queue<String> q = new LinkedList<>();

        HashSet<String> vis = new HashSet<>();
        vis.add("0000");
        q.add("0000");

        int level = 0;

        while(!q.isEmpty()) {
            int size = q.size();

            for(int i = 0; i < size; i++) {
                String curr = q.remove();
                if(deads.contains(curr)) continue;
                if(curr.equals(target)) return level;

                for(int j = 0; j < 4; j++) {
                    char c = curr.charAt(j);
                    String s1 = curr.substring(0, j) + (c == '9' ? 0 : c - '0' + 1) + curr.substring(j + 1);
                    String s2 = curr.substring(0, j) + (c == '0' ? 9 : c - '0' - 1) + curr.substring(j + 1);
                    if(!vis.contains(s1) && !deads.contains(s1)) {
                        q.add(s1);
                        vis.add(s1);
                    }
                    if(!vis.contains(s2) && !deads.contains(s2)) {
                        q.add(s2);
                        vis.add(s2);
                    }
                }

            }

            level++;
        }

        return -1;
    }
}