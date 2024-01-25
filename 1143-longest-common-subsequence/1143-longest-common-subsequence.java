class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length(), m = text2.length();

        // shifting 1-index to the right        
        int[] prev = new int[m + 1];
        int[] curr = new int[m + 1];

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(text1.charAt(i - 1) == text2.charAt(j - 1)){
                    curr[j] = 1 + prev[j - 1];
                }
                else curr[j] = Math.max(prev[j], curr[j - 1]);
            }
            prev = curr.clone();
        }

        return prev[m];
    }
}