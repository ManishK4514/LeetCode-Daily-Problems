class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int l = 0, r = 0, n = s.length(), cost = 0, ans = 0;

        while(r < n) {
            cost += Math.abs(s.charAt(r) - t.charAt(r));
            while(cost > maxCost) {
                cost -= Math.abs(s.charAt(l) - t.charAt(l));
                l++; 
            }
            ans = Math.max(ans, r - l + 1);
            r++;
        }

        return ans;
    }
}