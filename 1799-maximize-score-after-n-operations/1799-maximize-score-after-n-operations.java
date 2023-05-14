class Solution {
    int[] dp;
    
    public int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
    
    public int dfs(List<Integer> nums, int state, int current) {
        if (current == 0) return 0;
        if (dp[state] != 0) return dp[state];
        int result = 0, n = nums.size();
        
        List<Integer> total = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            if ((state & (1 << i)) != 0) {
                total.add(i);
            }
        }
        
        for (int i = 0; i < total.size(); i++) {
            for (int j = i + 1; j < total.size(); j++) {
                result = Math.max(result, gcd(nums.get(total.get(i)), nums.get(total.get(j))) * current 
                    + dfs(nums, (state & (~(1 << total.get(i)) & (~(1 << total.get(j))))), current - 1));
            }
        }
        
        dp[state] = result;
        return result;
    }
    
    public int maxScore(int[] nums) {
        int n = nums.length;
        dp = new int[1 << n];
        Arrays.fill(dp, 0);
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        return dfs(list, (1 << n) - 1, n / 2);
    }
}