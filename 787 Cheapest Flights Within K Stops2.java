/*
 * @Author: Hao Liu
 * @Date: 2019-08-09 16:49:30
 * @LastEditors: Hao Liu
 * @LastEditTime: 2019-08-09 16:50:05
 * @Description: Bellman-Ford's Algorithm, DP
 */

class Solution {
    private final int pMax = (int) 1e9;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[][] dp = new int[K + 2][n];
        for (int i = 0; i < K + 2; i++) {
            for (int j = 0; j < n; j++) {
                if (j != src) {
                    dp[i][j] = pMax;
                }
            }
        }
        for (int k = 1; k < K + 2; k++) {
            for (int[] flight : flights) {
                int start = flight[0];
                int end = flight[1];
                int price = flight[2];
                dp[k][end] = Math.min(dp[k][end], Math.min(dp[k - 1][end], dp[k - 1][start] + price));
            }
        }
        return dp[K + 1][dst] == pMax ? -1 : dp[K + 1][dst];
    }
}