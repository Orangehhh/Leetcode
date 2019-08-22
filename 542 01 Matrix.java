/*
 * @Author: Hao Liu
 * @Date: 2019-08-21 23:43:25
 * @LastEditors: Hao Liu
 * @LastEditTime: 2019-08-21 23:44:01
 * @Description: BFS
 */

class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] ans = new int[m][n];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    q.offer(i * n + j);
                }
            }
        }
        int dist = 0;
        int[] dirs = {-1, 0, 1, 0, -1};
        while (!q.isEmpty()) {
            dist++;
            int size = q.size();
            for (int l = 0; l < size; l++) {
                int num = q.poll();
                int i = num / n;
                int j = num % n;
                for (int k = 0; k < 4; k++) {
                    int r = i + dirs[k];
                    int c = j + dirs[k + 1];
                    if (r < 0 || c < 0 || r >= m || c >= n || matrix[r][c] == 0) {
                        continue;
                    }
                    ans[r][c] = dist;
                    matrix[r][c] = 0;
                    q.offer(r * n + c);
                }   
            }
        }
        return ans;
    }
}