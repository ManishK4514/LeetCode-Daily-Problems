class Solution {
    public boolean closeStrings(String word1, String word2) {
        int[] s1 = new int[26], s2 = new int[26], s3 = new int[26], s4 = new int[26];
        for(char ch : word1.toCharArray()){
            s1[ch - 'a']++;
            s3[ch - 'a'] = 1;
        }
        for(char ch : word2.toCharArray()){
            s2[ch - 'a']++;
            s4[ch - 'a'] = 1;
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