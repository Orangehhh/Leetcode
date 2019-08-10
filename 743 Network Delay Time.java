/*
 * @Author: Hao Liu
 * @Date: 2019-08-10 16:31:25
 * @LastEditors: Hao Liu
 * @LastEditTime: 2019-08-10 16:32:01
 * @Description: The Bellman-Ford Algorithm
 */

class Solution {
    private final int tMax = 101 * 100;
    public int networkDelayTime(int[][] times, int N, int K) {
        int[] dist = new int[N];
        for (int i = 0; i < N; i++) {
            dist[i] = tMax;
        }
        dist[K - 1] = 0;
        for (int i = 1; i < N; i++) {
            int[] tmp = Arrays.copyOf(dist, N);
            for (int[] time : times) {
                int start = time[0];
                int end = time[1];
                int cost = time[2];
                tmp[end - 1] = Math.min(tmp[end - 1], tmp[start - 1] + cost);
            }
            dist = Arrays.copyOf(tmp, N);
        }
        int ans = 0;
        for (int i = 0; i < N; i++) {
            ans = Math.max(ans, dist[i]);
        }
        return ans == tMax ? -1 : ans;
    }
}