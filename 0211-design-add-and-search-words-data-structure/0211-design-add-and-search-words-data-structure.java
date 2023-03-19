class WordDictionary {
    private WordDictionary[] newChildren;
    boolean newIsEndOfWord;
    public WordDictionary() {
        newChildren = new WordDictionary[26];
        newIsEndOfWord = false;
    }

    public void addWord(String newWord) {
        WordDictionary newCurr = this;
        for(char c: newWord.toCharArray()){
            if(newCurr.newChildren[c - 'a'] == null)
                newCurr.newChildren[c - 'a'] = new WordDictionary();
            newCurr = newCurr.newChildren[c - 'a'];
        }
        newCurr.newIsEndOfWord = true;
    }

    public boolean search(String newWord) {
        WordDictionary newCurr = this;
        for(int i = 0; i < newWord.length(); ++i){
            char c = newWord.charAt(i);
            if(c == '.'){
                for(WordDictionary newCh: newCurr.newChildren)
                    if(newCh != null && newCh.search(newWord.substring(i+1))) return true;
                return false;
            }
            if(newCurr.newChildren[c - 'a'] == null) return false;
            newCurr = newCurr.newChildren[c - 'a'];
        }
        return newCurr != null && newCurr.newIsEndOfWord;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */