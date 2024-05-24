class Pair {
    boolean possible;
    int score;

    Pair(boolean possible, int score) {
        this.possible = possible;
        this.score = score;
    }
}
class Solution {
    public Pair isValid(String word, int[] map, int[] score) {
        int[] freq = new int[26];
        for(int i = 0; i < word.length(); i++) freq[word.charAt(i) - 'a']++;

        int currScore = 0;
        for(int i = 0; i < 26; i++) {
            if(freq[i] > map[i]) return new Pair(false, currScore);
            currScore += freq[i] * score[i];
        }

        for(int i = 0; i < 26; i++) map[i] -= freq[i];
        return new Pair(true, currScore);
    }

    public int helper(int i, String[] words, int[] map, int[] score) {
        if(i == words.length) return 0;
        
        int[] tempMap = map.clone();
        Pair p = isValid(words[i], map, score);

        int pick = 0;

        if(p.possible) {
            pick = p.score + helper(i + 1, words, map, score);
        }

        map = tempMap.clone();

        int notPick = helper(i + 1, words, map, score);

        return Math.max(pick, notPick);
    }

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] map = new int[26];
        for(char ch : letters) map[ch - 'a']++;
        return helper(0, words, map, score);
    }
}