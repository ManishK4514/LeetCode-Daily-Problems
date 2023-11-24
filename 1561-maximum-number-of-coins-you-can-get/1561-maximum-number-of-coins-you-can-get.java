class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int n = piles.length, coins = 0;
        for(int i = n - 1, j = 0; i >= 0 && i > j; i -= 2, j++) {
            coins += piles[i - 1];
        }
        return coins;
    }
}