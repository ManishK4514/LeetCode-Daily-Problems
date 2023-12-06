class Solution {
    public int totalMoney(int n) {
        int sum = 0, lastMonday = 1;
        while(n > 0) {
            int start = lastMonday;
            int end = Math.min(lastMonday + 6, lastMonday + (n - 1));

            int totalSum = ((end * (end + 1))/2);
            int preSum = (((start - 1) * (start))/2);

            sum += totalSum - preSum;

            n -= 7;            
            lastMonday++;
        }

        return sum;
    }
}