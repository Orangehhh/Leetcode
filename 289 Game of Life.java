class Solution {
    
    private final int LIVE = 2;
    private final int DIE = 3;
    private final int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, -1}, {1, 1}, {-1, -1}, {-1, 1}};
    
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = 0;
                for (int[] dir : dirs) {
                    int r = i + dir[0];
                    int c = j + dir[1];
                    if (r < 0 || c < 0 || r >= m || c >= n) continue;
                    if (board[r][c] == 1 || board[r][c] == DIE) {
                        count++;
                    }
                }
                if (board[i][j] == 1 && (count < 2 || count > 3)) {
                    board[i][j] = DIE;
                }
                else if (board[i][j] == 0 && count == 3) {
                    board[i][j] = LIVE;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == LIVE) {
                    board[i][j] = 1;
                }
                else if (board[i][j] == DIE) {
                    board[i][j] = 0;
                }
            }
        }
    }
}