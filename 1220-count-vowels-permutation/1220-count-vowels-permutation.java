class Solution {
    int mod = (int)(1e9 + 7);
    public int helper(int idx, char prev, String vowels, int n, int[][] dp){
        if(idx == n) return 1;
        if(dp[idx][prev - 'a'] != -1) return dp[idx][prev - 'a'];
        int curr = 0;
        if(prev == 'a') curr = (curr + helper(idx + 1, 'e', vowels, n, dp)) % mod;
        else if(prev == 'e') {
            curr = (curr + helper(idx + 1, 'a', vowels, n, dp)) % mod;
            curr = (curr + helper(idx + 1, 'i', vowels, n, dp)) % mod;
        }
        else if(prev == 'o'){
            curr = (curr + helper(idx + 1, 'i', vowels, n, dp)) % mod;
            curr = (curr + helper(idx + 1, 'u', vowels, n, dp)) % mod;
        }
        else if(prev == 'u') curr += helper(idx + 1, 'a', vowels, n, dp);
        else {
            for(int i = 0; i < vowels.length(); i++){
                if(vowels.charAt(i) != 'i'){
                    curr = (curr + helper(idx + 1, vowels.charAt(i), vowels, n, dp)) % mod;
                }
            }
        }
        return dp[idx][prev - 'a'] = curr % mod;
    }
    public int countVowelPermutation(int n) {
        int[][] dp = new int[n + 1][26];
        for(int[] it : dp) Arrays.fill(it, -1);
        String vowels = "aeiou";
        int ans = 0;
        for(int i = 0; i < vowels.length(); i++){
            ans = (ans + helper(1, vowels.charAt(i), vowels, n, dp)) % mod;
        }
        return ans % mod;
    }
}