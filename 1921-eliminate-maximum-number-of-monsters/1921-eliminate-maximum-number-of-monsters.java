class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        int[] time = new int[n];

        for(int i = 0; i < n; i++) {
            time[i] = (dist[i] - 1)/speed[i];
        }

        Arrays.sort(time);

        for(int i = 0; i < n; i++) if(i > time[i]) return i;

        return n;
    }
}