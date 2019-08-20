/*
 * @Author: Hao Liu
 * @Date: 2019-08-20 12:57:04
 * @LastEditors: Hao Liu
 * @LastEditTime: 2019-08-20 12:57:18
 * @Description: DFS
 */

 class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, String word, int i, int j, int s) {
        if (s == word.length())     return true;
        int m = board.length;
        int n = board[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n)     return false;
        if (board[i][j] != word.charAt(s))      return false;
        char ch = board[i][j];
        board[i][j] = '.';
        if (dfs(board, word, i - 1, j, s + 1) ||
            dfs(board, word, i + 1, j, s + 1) ||
            dfs(board, word, i, j - 1, s + 1) ||
            dfs(board, word, i, j + 1, s + 1))  return true;
        board[i][j] = ch;
        return false;
    }
}
