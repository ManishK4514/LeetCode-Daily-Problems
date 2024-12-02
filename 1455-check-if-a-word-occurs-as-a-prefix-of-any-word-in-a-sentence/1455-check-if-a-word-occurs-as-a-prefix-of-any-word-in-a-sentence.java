class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] words = sentence.split(" ");
        int idx = 0;

        for(String word : words) {
            if(word.length() < searchWord.length()) {}
            else if(searchWord.equals(word.substring(0, searchWord.length()))) return ++idx;
            idx++;
        }
        
        return -1;
    }
}