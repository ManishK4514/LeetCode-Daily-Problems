class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int[] graph = new int[26];
        for(int i = 0; i < 26; i++) {
            graph[i] = i;
        }
        for(int i = 0; i < s1.length(); i++) {
            int a = s1.charAt(i) - 'a';
            int b = s2.charAt(i) - 'a';
            int end1 = find(graph, b);
            int end2 = find(graph, a);
            if(end1 < end2) {
                graph[end2] = end1;
            } else {
                graph[end1] = end2;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < baseStr.length(); i++) {
            char c = baseStr.charAt(i);
            sb.append((char)('a' + find(graph, c - 'a')));
        }
        return sb.toString();
    }
    
    private int find(int[] graph, int idx) {
        while(graph[idx] != idx) {
            idx = graph[idx];
        }
        return idx;
    }
}