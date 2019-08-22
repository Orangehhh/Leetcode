/*
 * @Author: Hao Liu
 * @Date: 2019-08-22 12:28:49
 * @LastEditors: Hao Liu
 * @LastEditTime: 2019-08-22 12:29:00
 * @Description: DFS + BFS
 */

 class Solution {
    public int shortestBridge(int[][] A) {
        Queue<Integer> q = new LinkedList<>();
        boolean found = false;
        int m = A.length;
        int n = A[0].length;
        for (int i = 0; i < m && !found; i++) {
            for (int j = 0; j < n && !found; j++) {
                if (A[i][j] == 1) {
                    dfs(q, A, i, j);
                    found = true;
                }
            }
        }
        int ans = 0;
        int[] dirs = {-1, 0, 1, 0, -1};
        while (!q.isEmpty()) {
            ans++;
            int size = q.size();
            for (int l = 0; l < size; l++) {
                int idx = q.poll();
                int r = idx / n;
                int c = idx % n;
                for (int k = 0; k < 4; k++) {
                    int nr = r + dirs[k];
                    int nc = c + dirs[k + 1];
                    if (nr < 0 || nc < 0 || nr >= m || nc >= n || A[nr][nc] == 2) {
                        continue;
                    }
                    if (A[nr][nc] == 1) {
                        return ans - 1;
                    }
                    A[nr][nc] = 2;
                    q.offer(nr * n + nc);
                }
            }
        }
        return -1;
    }
    
    private void dfs(Queue<Integer> q, int[][] A, int i, int j) {
        int m = A.length;
        int n = A[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n || A[i][j] != 1) return;
        A[i][j] = 2;
        q.offer(i * n + j);
        dfs(q, A, i - 1, j);
        dfs(q, A, i + 1, j);
        dfs(q, A, i, j + 1);
        dfs(q, A, i, j - 1);
    }
}
