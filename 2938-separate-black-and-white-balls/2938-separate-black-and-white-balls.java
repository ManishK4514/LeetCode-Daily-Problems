class Solution {
    public long minimumSteps(String s) {
        int zeros = 0, n = s.length();
        long ans = 0;

        for(int i = n - 1; i >= 0; i--) {
            if(s.charAt(i) == '0') zeros++;
            else ans += zeros;
        }

        return ans;
    }
}