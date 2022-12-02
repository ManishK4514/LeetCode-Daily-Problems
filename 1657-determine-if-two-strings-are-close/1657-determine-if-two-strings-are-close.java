class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()) return false;
        int[] s1 = new int[26], s2 = new int[26], s3 = new int[26], s4 = new int[26];
        for(int i = 0; i < word1.length(); i++){
            s1[word1.charAt(i) - 'a']++;
            s3[word1.charAt(i) - 'a'] = 1;
        }
        for(int i = 0; i < word1.length(); i++){
            s2[word2.charAt(i) - 'a']++;
            s4[word2.charAt(i) - 'a'] = 1;
        }
        Arrays.sort(s1);
        Arrays.sort(s2);
        for(int i = 0; i < s1.length; i++){
            if(s1[i] != s2[i]) return false;
        }
        for(int i = 0; i < s2.length; i++){
            if(s3[i] != s4[i]) return false;
        }
        return true;
    }
}