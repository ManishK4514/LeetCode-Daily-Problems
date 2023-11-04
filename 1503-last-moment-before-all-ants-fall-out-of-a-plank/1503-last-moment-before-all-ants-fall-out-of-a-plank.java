class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int ans = 0;

        for(int it : left) ans = Math.max(ans, it);
        for(int it : right) ans = Math.max(ans, n - it);
        
        return ans;
    }
}