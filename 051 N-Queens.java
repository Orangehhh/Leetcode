/*
 * @Author: Hao Liu
 * @Date: 2019-08-20 12:25:45
 * @LastEditors: Hao Liu
 * @LastEditTime: 2019-08-20 12:26:34
 * @Description: Backtracking, use array to record cols, diag1 and diag2
 */

class Solution {
    private int[] cols;
    private int[] diag1;
    private int[] diag2;
    public List<List<String>> solveNQueens(int n) {
        cols = new int[n];
        diag1 = new int[2 * n + 1];
        diag2 = new int[2 * n + 1];
        List<String> board = new ArrayList<>();
        List<List<String>> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < n; j++) {
            sb.append('.');
        }
        for (int i = 0; i < n; i++) {
            board.add(sb.toString());
        }
        dfs(ans, board, n, 0);
        return ans;
    }
    
    private void dfs(List<List<String>> ans, List<String> board, int n, int i) {
        if (i == n) {
            ans.add(new ArrayList<>(board));
            return;
        }
        for (int j = 0; j < n; j++) {
            if (!available(i, j, n))   continue;
            updateBoard(board, i, j, n, 1);
            dfs(ans, board, n, i + 1);
            updateBoard(board, i, j, n, 0);
        }
    }
    
    private void updateBoard(List<String> board, int i, int j, int n, int isPut) {
        cols[j] = isPut;
        diag1[i + j] = isPut;
        diag2[i - j + n - 1] = isPut;
        char[] chArr = board.get(i).toCharArray();
        chArr[j] = isPut == 1 ? 'Q' : '.';
        board.set(i, new String(chArr));
    }
    
    private boolean available(int i, int j, int n) {
        if (cols[j] != 0 || diag1[i + j] != 0 || diag2[i - j + n - 1] != 0) {
            return false;
        }
        return true;
    }
}