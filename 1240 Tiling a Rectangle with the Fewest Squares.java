class Solution {
    private int ans;
    public int tilingRectangle(int n, int m) {
        boolean[][] filled = new boolean[n][m];
        ans = m * n;
        dfs(filled, n, m, 0, 0, 0);
        return ans;
    }
    
    private void dfs(boolean[][] filled, int n, int m, int x, int y, int num) {
        if (num >= ans) {
            return;
        } 
        if (y == m) {
            dfs(filled, n, m, x + 1, 0, num);
            return;
        }
        if (x == n) {
            ans = num;
            return;
        } 
        if (filled[x][y]) {
            dfs(filled, n, m, x, y + 1, num);
            return;
        }
        int r = 0;
        for (int i = x; i < n; i++) {
            if (!filled[i][y])  r++;
            else break;
        }
        int c = 0;
        for (int j = y; j < m; j++) {
            if (!filled[x][j])  c++;
            else break;
        }
        int s = Math.min(r, c);
        for (int l = 1; l <= s; l++) {
            for (int i = x; i < x + l; i++) {
                for (int j = y; j < y + l; j++) {
                    filled[i][j] = true;
                }
            }
            dfs(filled, n, m, x, y + 1, num + 1);
            for (int i = x; i < x + l; i++) {
                for (int j = y; j < y + l; j++) {
                    filled[i][j] = false;
                }
            }
        }
    }
}