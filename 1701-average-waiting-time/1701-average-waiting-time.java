class Solution {
    public double averageWaitingTime(int[][] customers) {
        double ans = 0;
        int totalTime = 0, n = customers.length;

        for(int[] customer : customers) {
            int arrival = customer[0];
            int time = customer[1];
            int currCost = 0;
            totalTime = Math.max(totalTime, arrival);
            int prevTime = totalTime;

            if(totalTime > arrival) currCost += totalTime - arrival;

            totalTime += time;
            currCost += totalTime - prevTime;
            ans += currCost;
        }

        return ans/n;
    }
}