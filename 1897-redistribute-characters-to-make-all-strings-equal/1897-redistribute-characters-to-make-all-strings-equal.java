class Solution {
    public boolean makeEqual(String[] words) {
        int n = words.length;
        int[] map = new int[26];
        
        for(int i = 0; i < words.length; i++) {
            for(int j = 0; j < words[i].length(); j++) {
                map[words[i].charAt(j) - 'a']++;
            }
        }

        for(int i = 0; i < 26; i++) if(map[i] % n != 0) return false;

        return true;
    }
}