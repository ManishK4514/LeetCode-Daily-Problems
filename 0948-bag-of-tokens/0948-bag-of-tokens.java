class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int n = tokens.length;
        int score = 0, l = 0, r = n - 1, maxScore = 0;

        Arrays.sort(tokens);

        while(l <= r) {
            if(power >= tokens[l]){
                power -= tokens[l];
                score++; l++;
            }
            else if(score >= 1){
                power += tokens[r];
                score--; r--;
            }
            else break;
            maxScore = Math.max(score, maxScore);
        }

        return maxScore;
    }
}