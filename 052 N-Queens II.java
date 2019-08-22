/*
 * @Author: Hao Liu
 * @Date: 2019-08-20 12:32:57
 * @LastEditors: Hao Liu
 * @LastEditTime: 2019-08-20 12:33:29
 * @Description: Almost same as LC 51, No need to generate board
 */

 class Solution {
    private int[] cols;
    private int[] diag1;
    private int[] diag2;
    private int ans;
    
    public int totalNQueens(int n) {
        cols = new int[n];
        diag1 = new int[2 * n + 1];
        diag2 = new int[2 * n + 1];
        ans = 0;
        dfs(n, 0);
        return ans;
    }
    
    private void dfs(int n, int i) {
        if (i == n) {
            ans++;
            return;
        }
        for (int j = 0; j < n; j++) {
            if (!available(i, j, n))    continue;
            cols[j] = 1;
            diag1[i + j] = 1;
            diag2[i - j + n - 1] = 1;
            dfs(n, i + 1);
            cols[j] = 0;
            diag1[i + j] = 0;
            diag2[i - j + n - 1] = 0;
        }
    }
    
    private boolean available(int i, int j, int n) {
        if (cols[j] != 0 || diag1[i + j] != 0 || diag2[i - j + n - 1] != 0) {
            return false;
        }
        return true;
    }
}
