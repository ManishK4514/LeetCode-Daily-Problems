class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int n = allowed.length(), m = words.length;
        int[] map = new int[26];
        for(int i = 0; i < n; i++) {
            map[allowed.charAt(i) - 'a']++;
        }

        int ans = 0;

        for(String word : words) {
            boolean consistent = true;
            for(char ch : word.toCharArray()) {
                if(map[ch - 'a'] == 0) {
                    consistent = false;
                    break;
                }
            }
            if(consistent) ans++;
        }

        return ans;
    }
}