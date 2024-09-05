class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int len = n + m, currSum = 0;
        
        for(int roll : rolls) currSum += roll;
        int totalSum = len * mean;
        int requiredSum = totalSum - currSum;
        
        if(n > requiredSum || requiredSum > 6 * n) return new int[]{};

        int[] ans = new int[n];
        int idx = 0;

        while(requiredSum > 0) {
            ans[idx] += 1;
            idx = (idx + 1) % n;
            requiredSum--;
        }

        return ans;
    }
}