class Solution {
    public int maxScore(String s) {
        int ones = 0, zeros = 0, n = s.length(), ans = 0;
        for(int i = 0; i < n; i++) if(s.charAt(i) == '1') ones++;

        for(int i = 0; i < n - 1; i++) {
            if(s.charAt(i) == '1') ones--;
            else  zeros++;
            
            ans = Math.max(ones + zeros, ans);
        }

        return ans;
    }
}