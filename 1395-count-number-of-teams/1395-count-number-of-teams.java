class Solution {
    private int[][][] dp1;
    private int[][][] dp2;

    public int helper1(int i, int[] rating, int prevIdx, int count) {
        if (count == 0) return 1;
        if (i == rating.length) return 0;
        if (prevIdx != -1 && dp1[i][prevIdx][count] != -1) return dp1[i][prevIdx][count];

        int ans = 0;

        if (prevIdx == -1 || rating[i] > rating[prevIdx]) {
            ans += helper1(i + 1, rating, i, count - 1);
        }

        ans += helper1(i + 1, rating, prevIdx, count);

        if (prevIdx != -1) dp1[i][prevIdx][count] = ans;
        return ans;
    }

    public int helper2(int i, int[] rating, int prevIdx, int count) {
        if (count == 0) return 1;
        if (i == rating.length) return 0;
        if (prevIdx != -1 && dp2[i][prevIdx][count] != -1) return dp2[i][prevIdx][count];

        int ans = 0;

        if (prevIdx == -1 || rating[i] < rating[prevIdx]) {
            ans += helper2(i + 1, rating, i, count - 1);
        }

        ans += helper2(i + 1, rating, prevIdx, count);

        if (prevIdx != -1) dp2[i][prevIdx][count] = ans;
        return ans;
    }

    public int numTeams(int[] rating) {
        int n = rating.length;
        dp1 = new int[n][n][4];
        dp2 = new int[n][n][4];
        for (int[][] layer1 : dp1) {
            for (int[] layer2 : layer1) {
                Arrays.fill(layer2, -1);
            }
        }
        for (int[][] layer1 : dp2) {
            for (int[] layer2 : layer1) {
                Arrays.fill(layer2, -1);
            }
        }
        return helper1(0, rating, -1, 3) + helper2(0, rating, -1, 3);
    }
}