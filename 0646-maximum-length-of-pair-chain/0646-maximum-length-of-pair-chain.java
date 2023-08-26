class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b)->{return a[1] - b[1];});
        int ans = 0, curr = 0, prev = Integer.MIN_VALUE;
        for(int i = 0; i < pairs.length; i++){
            if(pairs[i][0] > prev) {
                curr++;
                prev = pairs[i][1];
            }
        }
        ans = Math.max(ans, curr);
        return ans;
    }
}