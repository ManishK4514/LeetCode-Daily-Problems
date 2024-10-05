class Solution {
    public boolean isValid(int[] map1, int[] map2) {
        for(int i = 0; i < 26; i++) if(map1[i] != map2[i]) return false;
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length(), l = 0;
        int[] map1 = new int[26];
        int[] map2 = new int[26];

        if(n > m) return false;

        for(int r = 0; r < m; r++){
            if(r < n) {
                char ch1 = s1.charAt(r);
                map1[ch1 - 'a']++;                
            }
            
            char ch2 = s2.charAt(r);
            map2[ch2 - 'a']++;
            
            if(r >= n - 1) {
                if(isValid(map1, map2)) return true;
                char toRemove = s2.charAt(l++);
                map2[toRemove - 'a']--;   
            }
        }
        return false;
    }
}