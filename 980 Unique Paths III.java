/*
 * @Author: Hao Liu
 * @Date: 2019-08-17 14:18:16
 * @LastEditors: Hao Liu
 * @LastEditTime: 2019-08-17 14:18:30
 * @Description: DFS
 */

class Solution {
    
    private int ans;
    
    public int uniquePathsIII(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] isVisited = new boolean[m][n];
        int count = 0;
        ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != -1) {
                    count += 1;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    isVisited[i][j] = true;
                    dfs(grid, i, j, 1, count, isVisited);
                }
            }
        }
        return ans;
    }
    
    private void dfs(int[][] grid, int i, int j, int steps, int count, boolean[][] isVisited) {
        if (grid[i][j] == 2) {
            if (steps == count) {
                ans += 1;
            }
            return;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[] dirs = {-1, 0, 1, 0, -1};
        for (int k = 0; k < 4; k++) {
            int r = i + dirs[k];
            int c = j + dirs[k + 1];
            if (r < 0 || c < 0 || r >= m || c >= n || grid[r][c] == -1 || isVisited[r][c]) continue;
            isVisited[r][c] = true;
            dfs(grid, r, c, steps + 1, count, isVisited);
            isVisited[r][c] = false;
        }
    }
}