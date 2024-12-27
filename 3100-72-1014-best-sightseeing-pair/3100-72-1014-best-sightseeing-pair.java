class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length, max = 0, maxIdx = 0, ans = 0;

        for(int i = 0; i < n; i++) {                     
            if(i != maxIdx) {
                ans = Math.max(ans, values[i] + values[maxIdx] + maxIdx - i);
            }

            if(max < values[i] + i) {
                max = values[i] + i;
                maxIdx = i;
            }
        }

        return ans;
    }
}