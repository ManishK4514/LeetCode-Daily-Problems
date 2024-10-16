class Pair {
    char ch;
    int freq;
    Pair(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }
}
class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y)->{
            return y.freq - x.freq;
        });

        if(a > 0) pq.add(new Pair('a', a));
        if(b > 0) pq.add(new Pair('b', b));
        if(c > 0) pq.add(new Pair('c', c));

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            Pair first = pq.remove();
            int len = sb.length();

            if(len < 2 || (sb.charAt(len - 1) != sb.charAt(len - 2)) || sb.charAt(len - 1) != first.ch) {
                sb.append(first.ch);
                first.freq -= 1;
            }
            else {
                if(!pq.isEmpty()) {
                    Pair second = pq.remove();
                    sb.append(second.ch);
                    second.freq -= 1;

                    if(second.freq > 0) pq.add(second);
                }
                else break;
            }

            if(first.freq > 0) pq.add(first);
        }

        return sb.toString();
    }
}