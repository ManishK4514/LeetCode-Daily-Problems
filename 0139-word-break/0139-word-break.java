class Solution {
    public static boolean check(String s, int idx, HashSet<String> wordDict, Boolean[] dp){
        if(idx == s.length()) return true;

        if(dp[idx] != null) return dp[idx];
        
        for(int i = idx; i < s.length(); i++){
            if(wordDict.contains(s.substring(idx, i + 1))){
                if(check(s, i + 1, wordDict, dp)) return true;
            }
        }
        return dp[idx] = false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet(wordDict);  
        Boolean[] dp = new Boolean[s.length()];      
        return check(s, 0, set, dp);
    }
}