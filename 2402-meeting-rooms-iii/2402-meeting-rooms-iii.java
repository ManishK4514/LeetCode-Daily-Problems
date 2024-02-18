class Solution {
    public int mostBooked(int n, int[][] meetings) {
        int m = meetings.length;

        Arrays.sort(meetings, (a, b) -> {
            return a[0] - b[0];
        });

        long[][] rooms = new long[n][2];
        int[] freq = new int[n];
        int max = 0;

        for (long[] it : rooms) Arrays.fill(it, -1);

        for (int i = 0; i < m; i++) {
            long minEndTime = Long.MAX_VALUE;
            int minIndex = -1;

            for (int j = 0; j < n; j++) {
                if (rooms[j][1] <= meetings[i][0]) {
                    minIndex = j;
                    break;
                }
            }

            if (minIndex == -1) {
                for (int j = 0; j < n; j++) {
                    if (minEndTime > rooms[j][1]) {
                        minEndTime = rooms[j][1];
                        minIndex = j;
                    }
                }
            }

            rooms[minIndex][0] = Math.max(rooms[minIndex][1], meetings[i][0]);
            rooms[minIndex][1] = rooms[minIndex][0] + meetings[i][1] - meetings[i][0];

            freq[minIndex]++;
            max = Math.max(freq[minIndex], max);
        }

        for (int i = 0; i < n; i++) {
            if (freq[i] == max) return i;
        }

        return -1;
    }
}
