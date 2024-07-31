class Solution {
    int shelfWidth;

    public int helper(int i, int[][] books, int remainingWidth, int maxHeight, int[][] dp) {
        if (i == books.length) return maxHeight;

        if (dp[i][remainingWidth] != -1) return dp[i][remainingWidth];

        int bookWidth = books[i][0];
        int bookHeight = books[i][1];

        int keep = Integer.MAX_VALUE;
        int notKeep = Integer.MAX_VALUE;

        // insert in same row
        if (bookWidth <= remainingWidth) {
            keep = helper(i + 1, books, remainingWidth - bookWidth, Math.max(bookHeight, maxHeight), dp);
        }

        notKeep = maxHeight + helper(i + 1, books, shelfWidth - bookWidth, bookHeight, dp);

        dp[i][remainingWidth] = Math.min(keep, notKeep);
        return dp[i][remainingWidth];
    }

    public int minHeightShelves(int[][] books, int shelfWidth) {
        this.shelfWidth = shelfWidth;
        int n = books.length;
        int[][] dp = new int[n][shelfWidth + 1];
        for (int[] it : dp) Arrays.fill(it, -1);
        return helper(0, books, shelfWidth, 0, dp);
    }
}
