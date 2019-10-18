class Solution {
    public int[][] candyCrush(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return board;
        }
        int m = board.length;
        int n = board[0].length;
        boolean flag = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n - 2; j++) {
                int val = Math.abs(board[i][j]);
                if (val != 0 && val == Math.abs(board[i][j + 1]) && val == Math.abs(board[i][j + 2])) {
                    board[i][j] = -val;
                    board[i][j + 1] = -val;
                    board[i][j + 2] = -val;
                    flag = true;
                }
            }
        }
        for (int i = 0; i < m - 2; i++) {
            for (int j = 0; j < n; j++) {
                int val = Math.abs(board[i][j]);
                if (val != 0 && val == Math.abs(board[i + 1][j]) && val == Math.abs(board[i + 2][j])) {
                    board[i][j] = -val;
                    board[i + 1][j] = -val;
                    board[i + 2][j] = -val;
                    flag = true;
                }
            }
        }
        for (int j = 0; j < n; j++) {
            int idx = m - 1;
            for (int i = m - 1; i >= 0; i--) {
                if (board[i][j] >= 0) {
                    board[idx--][j] = board[i][j];
                }
            }
            while (idx >= 0) {
                board[idx--][j] = 0;
            }
        }
        return flag ? candyCrush(board) : board;
    }
}