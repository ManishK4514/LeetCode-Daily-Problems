class Solution {
    public int helper(List<List<Integer>> piles, int idx, int k, List<List<Integer>> prefixSum, int[][] dp){
        if(k <= 0) return 0;
        if(idx == piles.size()) return 0; 
        if(dp[idx][k] != -1) return dp[idx][k];
        int maxCoins = 0;
        for(int i = 0; i <= Math.min(piles.get(idx).size(), k); i++){
            if(i == 0) {
                int currCoins = 0 + helper(piles, idx + 1, k, prefixSum, dp);
                maxCoins = Math.max(currCoins, maxCoins);
            }
            else {
                int currCoins = prefixSum.get(idx).get(i - 1) + helper(piles, idx + 1, k - i, prefixSum, dp);
                maxCoins = Math.max(currCoins, maxCoins);
            }
        }
        return dp[idx][k] = maxCoins;
    }
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        List<List<Integer>> prefixSum = new ArrayList<>(); 
        int[][] dp = new int[1001][2001];
        for(int[] it : dp) Arrays.fill(it, -1);
        for (List<Integer> pile : piles) {
            List<Integer> temp = new ArrayList<>();
            int sum = 0;
            for (int num : pile) {
                sum += num;
                temp.add(sum);
            }
            prefixSum.add(temp);
        }

        return helper(piles, 0, k, prefixSum, dp);
    }
}