class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length, l = 0, r = 0, sum = 0, max = 0;
        int[] prefix = new int[n];

        for(int i = 0; i < n; i++) {
            prefix[i] = grumpy[i] == 0 ? customers[i] : 0;
            if(i > 0) prefix[i] += prefix[i - 1]; 
        }

        while(r < n) {
            sum += customers[r];

            while(r - l + 1 > minutes) {
                sum -= customers[l];
                l++;
            }

            int leftSum = l <= 0 ? 0 : prefix[l - 1];
            int rightSum = r >= n - 1 ? 0 : prefix[n - 1] - prefix[r];

            max = Math.max(max, leftSum + rightSum + sum);

            r++;
        }

        return max;
    }
}