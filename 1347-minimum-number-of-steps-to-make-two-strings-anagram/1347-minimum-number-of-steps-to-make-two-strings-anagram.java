class Solution {
    public int minSteps(String s, String t) {
        int n = s.length();
        int[] map = new int[26];
        for(int i = 0; i < n; i++) map[s.charAt(i) - 'a']++;

        for(int i = 0; i < n; i++) {
            if(map[t.charAt(i) - 'a'] > 0) map[t.charAt(i) - 'a']--;
        }

        int ans = 0;
        for(int it : map) ans += it;
        return ans;
    }
}