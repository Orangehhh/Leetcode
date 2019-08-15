/*
 * @Author: Hao Liu
 * @Date: 2019-08-14 23:28:58
 * @LastEditors: Hao Liu
 * @LastEditTime: 2019-08-14 23:30:37
 * @Description: Graph, BFS, State, similar to LC 847
 */

class Solution {
    public int shortestPathAllKeys(String[] grid) {
        int m = grid.length;
        int n = grid[0].length();
        int allKey = 0;
        Queue<Integer> q = new LinkedList<>();
        int[][][] visited = new int[m][n][64];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char ch = grid[i].charAt(j);
                if (ch == '@') {
                    q.offer((i << 16) + (j << 8));
                    visited[i][j][0] = 1;
                }
                else if (ch >= 'a' && ch <= 'f') {
                    allKey |= 1 << (ch - 'a');
                }
            }
        }
        int[] dirs = {-1, 0, 1, 0, -1};
        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                int state = q.poll();
                int i = state >> 16;
                int j = (state >> 8) & 0xFF;
                int keys = state & 0xFF;
                if (keys == allKey)     return steps;
                for (int k = 0; k < 4; k++) {
                    int r = i + dirs[k];
                    int c = j + dirs[k + 1];
                    int nKeys = keys;
                    if (r < 0 || c < 0 || r >= m || c >= n) continue;
                    char ch = grid[r].charAt(c);
                    if (ch == '#')  continue;
                    if (ch >= 'A' && ch <= 'F' && (nKeys & 1 << (ch -'A')) == 0) continue;
                    if (ch >= 'a' && ch <= 'f') {
                        nKeys |= 1 << (ch - 'a');
                    }
                    if (visited[r][c][nKeys] == 1)   continue;
                    q.offer((r << 16) + (c << 8) + nKeys);
                    visited[r][c][nKeys] = 1;
                }
                size--;
            }
            steps++;
        }
        return -1;
    }
}