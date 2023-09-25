class Solution {
    public char findTheDifference(String s, String t) {
        int[] map1 = new int[26];
        int[] map2 = new int[26];
        
        for(int i = 0; i < t.length(); i++) {
            if(i < s.length()) map1[s.charAt(i) - 'a']++;
            map2[t.charAt(i) - 'a']++;
        }

        for(int i = 0; i < 26; i++) if(map1[i] < map2[i]) return (char)('a' + i);

        return '$';
    }
}