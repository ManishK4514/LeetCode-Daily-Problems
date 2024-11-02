class Solution {
    public boolean isCircularSentence(String sentence) {
        int prevIdx = -1, n = sentence.length();

        for(int i = 0; i < n; i++) {
            if(sentence.charAt(i) == ' ') {
                if(sentence.charAt(i - 1) != sentence.charAt(i + 1)) return false;
            }
        }

        if(sentence.charAt(n - 1) != sentence.charAt(0)) return false;

        return true;
    }
}