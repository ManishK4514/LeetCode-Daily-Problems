class Solution {
    public int numWays(String[] words, String target) {
        int m = words[0].length();
        int n = target.length();
        int[][] dp = new int[m][n];
        int[][] freq = new int[m][26];
        
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
                int charIndex = c - 'a'; 
                freq[j][charIndex]++;
            }
        }
        
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        
        return (int)helper(words, target, 0, 0, dp, freq);
    }
    
    private long helper(String[] words, String target, int i, int j, int[][] dp, int[][] freq) {
        if (j == target.length()) {
            return 1;
        }
        
        if (i == words[0].length() || words[0].length() - i < target.length() - j) {
            return 0;
        }
        
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        
        long count = 0;
        int curPos = target.charAt(j) - 'a';
        count += helper(words, target, i + 1, j, dp, freq);
        count += freq[i][curPos] * helper(words, target, i + 1, j + 1, dp, freq);
        
        dp[i][j] = (int)(count % 1000000007);
        return dp[i][j];
    }
}
