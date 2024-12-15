class Pair {
    double x, y;

    Pair(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        int n = classes.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b)->{
            double adiff = (a.x + 1)/(a.y + 1) - (a.x / a.y);                
            double bdiff = (b.x + 1)/(b.y + 1) - (b.x / b.y);
            if(adiff == bdiff) return 0;
            return adiff > bdiff ? -1 : 1;
        });

        for (int i = 0; i < n; i++) {
            pq.add(new Pair(classes[i][0], classes[i][1]));
        }

        while (extraStudents-- > 0) {
            Pair pair = pq.poll();
            double x = pair.x;
            double y = pair.y;
            x += 1;
            y += 1;
            pq.add(new Pair(x, y));
        }

        double ans = 0;
        for (int i = 0; i < n; i++) {
            Pair pair = pq.poll();
            double x = pair.x;
            double y = pair.y;
            ans += (double) x / y;
        }

        return ans / n;
    }
}
