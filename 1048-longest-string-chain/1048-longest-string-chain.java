class Solution {
    public boolean isValid(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if(m - n != 1) return false;

        int i = 0, j = 0, diff = 0;

        while(i < n && j < m){
            if(s1.charAt(i) != s2.charAt(j)){
                diff++;
                j++;
            }
            else{
                i++; j++;
            }
        }
        return diff <= 1;
    }
    public int longestStrChain(String[] words) {
        int n = words.length, max = 1;
        Arrays.sort(words, (a, b)->{return a.length() - b.length();});

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for(int i = 0; i < n; i++) {
            for(int prevIdx = 0; prevIdx < i; prevIdx++) {
                String s1 = words[prevIdx];
                String s2 = words[i];
                
                if(isValid(s1, s2) && dp[i] < dp[prevIdx] + 1){
                    dp[i] = dp[prevIdx] + 1;
                }
            }
            max = Math.max(max, dp[i]);
        }

        // System.out.println(Arrays.toString(dp));

        return max;
    }
}