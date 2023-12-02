class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] map = new int[26];
        for(char ch : chars.toCharArray()) map[ch - 'a']++;

        int ans = 0;

        for(String word : words) {
            int[] curr = new int[26];
            boolean canFormed = true;
            for(char ch : word.toCharArray()) {
                curr[ch - 'a']++;
                if(map[ch - 'a'] < curr[ch - 'a']) {
                    canFormed = false;
                    break;
                }
            }
            
            if(canFormed) ans += word.length();
        }

        return ans;
    }
}