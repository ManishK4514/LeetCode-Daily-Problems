class Solution {
    public boolean helper(int row, int col, int i, char[][] board, String word, int[] delRow, int[] delCol, int n, int m) {
        if(i == word.length()) return true;

        if(row < 0 || col < 0 || row == n || col == m || board[row][col] != word.charAt(i)) return false;

        char ch = board[row][col];
        board[row][col] = '#';

        for(int j = 0; j < 4; j++) {
            int nrow = row + delRow[j];
            int ncol = col + delCol[j];

            if(helper(nrow, ncol, i + 1, board, word, delRow, delCol, n, m)) return true;
        }

        board[row][col] = ch;

        return false;
    }

    public boolean exist(char[][] board, String word) {
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};
        int n = board.length;
        int m = board[0].length;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(helper(i, j, 0, board, word, delRow, delCol, n, m)) return true;
            }
        }
        
        return false;
    }
}