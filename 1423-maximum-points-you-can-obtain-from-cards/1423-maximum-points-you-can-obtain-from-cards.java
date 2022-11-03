class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int[] prefixSum = new int[n];
        int sum = 0;
        for(int i = 0; i < n; i++){
            prefixSum[i] = (sum += cardPoints[i]);
        }
        System.out.println(Arrays.toString(prefixSum));
        int max = Integer.MIN_VALUE;
        int i = 0, j = 0;
        sum = 0;
        while(j < (n - k)){
            sum += cardPoints[j];
            j++;
        }
        max = Math.max(max, prefixSum[n - 1] - sum);
        while(j < n){
            sum += cardPoints[j];
            sum -= cardPoints[i++];
            max = Math.max(max, prefixSum[n - 1] - sum);
            j++;
        }
        return max;
    }
}