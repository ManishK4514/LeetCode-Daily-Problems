class Solution {
    public static int solve(String text1, String text2, int i, int j, int[][] dp){
        if(i == text1.length() || j == text2.length()) return 0;
        int ans;
        if(dp[i][j] != -1) return dp[i][j];
        if(text1.charAt(i) == text2.charAt(j)){
            ans = 1 + solve(text1, text2, i + 1, j + 1, dp);
        }
        else{
            ans = Math.max(solve(text1, text2, i + 1, j, dp), solve(text1, text2, i,j + 1, dp));
        }
        dp[i][j] = ans;
        return dp[i][j];
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for(int[] nums : dp){
            Arrays.fill(nums, -1);
        }
        return solve(text1, text2, 0, 0, dp);
    }
}