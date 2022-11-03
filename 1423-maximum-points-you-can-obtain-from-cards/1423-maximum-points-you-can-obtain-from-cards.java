class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += cardPoints[i];
        }
        int max = Integer.MIN_VALUE;
        int i = 0, j = 0;
        int tempsum = 0;
        while(j < (n - k)){
            tempsum += cardPoints[j];
            j++;
        }
        max = Math.max(max, sum - tempsum);
        while(j < n){
            tempsum += cardPoints[j];
            tempsum -= cardPoints[i++];
            max = Math.max(max, sum - tempsum);
            j++;
        }
        return max;
    }
}