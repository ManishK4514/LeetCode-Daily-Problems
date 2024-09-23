class Solution {
    public int helper(String s, HashSet<String> set, int i, int[] dp) {
        if(i == s.length()) return 0;

        if(dp[i] != -1) return dp[i];

        int ans = (int)(1e9);

        // not pick
        ans = Math.min(ans, 1 + helper(s, set, i + 1, dp));
        
        StringBuilder sb = new StringBuilder();

        for(int j = i; j < s.length(); j++) {
            sb.append(s.charAt(j));
            if(set.contains(sb.toString())) {
                ans = Math.min(ans, helper(s, set, j + 1, dp));
            }
        }

        return dp[i] = ans;
    }
    public int minExtraChar(String s, String[] dictionary) {
        HashSet<String> set = new HashSet<>();
        for(String it : dictionary) set.add(it);
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return helper(s, set, 0, dp);
    }
}