class Solution {
    public int helper(int i, int[] stoneValue, int[] dp){
        if(i >= stoneValue.length) return 0;
        if(dp[i] != -1) return dp[i];
        int ans = Integer.MIN_VALUE, total = 0;
        for(int j = 0; j < 3; j++){
            if(i + j < stoneValue.length) total += stoneValue[i + j];
            ans = Math.max(ans, total - helper(i + j + 1, stoneValue, dp));
        }
        return dp[i] = ans;
    }
    public String stoneGameIII(int[] stoneValue) {
        int[] dp = new int[stoneValue.length];
        Arrays.fill(dp, -1);
        int totalSum = 0; // a + b
        for(int i = 0; i < stoneValue.length; i++) totalSum += stoneValue[i];        
        // diff = a - b
        int diff = helper(0, stoneValue, dp);
        
        // a = (totalSum + diff)/2 
        // a = (a + b - a - b)/2
        // a = 2a/2
        // a = a

        int alice = (totalSum + diff)/2;
        int bob = totalSum - alice;
        return alice == bob ? "Tie" : alice > bob ? "Alice" : "Bob";
    }
}