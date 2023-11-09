class Solution {
    public int countHomogenous(String s) {
        long ans = 1, cnt = 1, mod = (long)(1e9 + 7);
        for(int i = 1; i < s.length(); i++) {
            cnt = (s.charAt(i) == s.charAt(i - 1)) ? cnt + 1 : 1;
            ans = (ans + cnt) % mod;
        }
        return (int)(ans % mod);
    }
}