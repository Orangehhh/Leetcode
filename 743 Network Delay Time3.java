/*
 * @Author: Hao Liu
 * @Date: 2019-08-12 22:25:41
 * @LastEditors: Hao Liu
 * @LastEditTime: 2019-08-12 22:25:55
 * @Description: The Floyd-Warshall algorithm
 */

class Solution {
    private final int DMAX = 101 * 100;
    public int networkDelayTime(int[][] times, int N, int K) {
        int[][] dist = new int[N + 1][N + 1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                if (i != j) {
                    dist[i][j] = DMAX;
                }
            }
        }
        for (int[] time : times) {
            dist[time[0]][time[1]] = time[2];
        }
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    dist[i][j] = Math.min(dist[i][j], 
                                             dist[i][k] + dist[k][j]);
                }
            }
        }
        int ans = 0;
        for (int i = 1; i <= N; i++) {
            ans = Math.max(ans, dist[K][i]);
        }
        return ans == DMAX ? -1 : ans;
    }
}