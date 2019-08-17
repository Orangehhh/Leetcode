/*
 * @Author: Hao Liu
 * @Date: 2019-08-17 12:18:03
 * @LastEditors: Hao Liu
 * @LastEditTime: 2019-08-17 12:18:33
 * @Description: Similar to TSP, DP
 */

class Solution {
    public String shortestSuperstring(String[] A) {
        int n = A.length;
        int[][] dist = new int[n][n];
        preprocess(dist, A);
        int[][] dp = new int[1 << n][n];
        int[][] parent = new int[1 << n][n];
        for (int i = 0; i < (1 << n); i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                parent[i][j] = -1;
            }
        }
        for (int i = 0; i < n; i++) {
            dp[1 << i][i] = A[i].length();
        }
        for (int k = 0; k < (1 << n); k++) {
            for (int i = 0; i < n; i++) {
                if ((k & (1 << i)) == 0)  continue;
                for (int j = 0; j < n; j++) {
                    if (i == j) continue;
                    if ((k & (1 << j)) == 0)  continue;
                    if (dp[k - (1 << i)][j] != Integer.MAX_VALUE &&
                        dp[k][i] > dp[k - (1 << i)][j] + dist[j][i]) {
                        dp[k][i] = dp[k - (1 << i)][j] + dist[j][i];
                        parent[k][i] = j;
                    }
                }
            }
        }
        int idx = -1;
        int minDist = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (dp[(1 << n) - 1][i] < minDist) {
                idx = i;
                minDist = dp[(1 << n) - 1][i];
            }
        }
        StringBuilder ans = new StringBuilder();
        int cur = (1 << n) - 1;
        while (cur > 0) {
            String str = A[idx];
            int prevIdx = parent[cur][idx];
            if (prevIdx == -1)  ans.insert(0, str);
            else ans.insert(0, str.substring(str.length() - dist[prevIdx][idx], str.length()));
            cur &= (~(1 << idx));
            idx = prevIdx;
        }
        return ans.toString();
    }
    
    private void preprocess(int[][] dist, String[] A) {
        int n = A.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                String si = A[i];
                String sj = A[j];
                for (int k = 0; k <= Math.min(si.length(), sj.length()); k++) {
                    if (si.substring(si.length() - k, si.length())
                        .equals(sj.substring(0, k))) {
                        dist[i][j] = sj.length() - k;
                    }
                }
            }
        }
    }
}