/*
 * @Author: Hao Liu
 * @Date: 2019-08-20 09:58:47
 * @LastEditors: Hao Liu
 * @LastEditTime: 2019-08-20 09:59:10
 * @Description: Backtracking
 */

 class Solution {
    private int[][] rows;
    private int[][] cols;
    private int[][] cells;
    public void solveSudoku(char[][] board) {
        rows = new int[10][10];
        cols = new int[10][10];
        cells = new int[10][10];
        for (int k = 0; k < 9; k++) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int r = i + 3 * (k / 3);
                    int c = j + 3 * (k % 3);
                    if (board[r][c] == '.') continue;
                    int num = board[r][c] - '0';
                    rows[r][num] = 1;
                    cols[c][num] = 1;
                    cells[k][num] = 1;
                }
            }
        }
        solve(board, 0, 0);
    }
    
    private boolean solve(char[][] board, int i, int j) {
        if (i == 9) return true;
        
        int ni = j == 8 ? i + 1 : i;
        int nj = (j + 1) % 9;
        if (board[i][j] != '.') return solve(board, ni, nj);
        
        int k = (i / 3) * 3 + (j / 3);
        for (int num = 1; num <= 9; num++) {
            if (rows[i][num] != 0 || 
                cols[j][num] != 0 ||
                cells[k][num] != 0)  continue;
            board[i][j] = (char) (num + '0'); 
            rows[i][num] = 1;
            cols[j][num] = 1;
            cells[k][num] = 1;
            if (solve(board, ni, nj)) {
                return true;
            }
            rows[i][num] = 0;
            cols[j][num] = 0;
            cells[k][num] = 0;
            board[i][j] = '.';
        }
        return false;
    }
}
