class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int[][][] dp = new int[n * 2 + 1][n + 1][n + 1];
        for (int i = 0; i <= n * 2; i++) {
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= n; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        dp[0][0][0] = 0;
        dp[0][1][0] = 0;
        dp[0][1][1] = 0;
        dp[1][0][0] = 0;
        dp[1][0][1] = 0;
        for (int l = 2; l <= n * 2; l++) {
            for (int x1 = 1; x1 <= n; x1++) {
                for (int x2 = 1; x2 <= n; x2++) {
                    int y1 = l - x1;
                    int y2 = l - x2;
                    if (y1 < 1 || y1 > n || y2 < 1 || y2 > n) continue;
                    if (grid[x1 - 1][y1 - 1] == -1 || 
                        grid[x2 - 1][y2 - 1] == -1) {
                        dp[l][x1][x2] = -1;
                        
                    }
                    else {
                        dp[l][x1][x2] = grid[x1 - 1][y1 - 1];
                        if (x1 != x2) {
                            dp[l][x1][x2] += grid[x2 - 1][y2 - 1];
                        }
                        int prev = Math.max(Math.max(dp[l - 1][x1][x2 - 1], 
                                            dp[l - 1][x1][x2]),
                                    Math.max(dp[l - 1][x1 - 1][x2 - 1],
                                             dp[l - 1][x1 - 1][x2]));
                        if (prev == -1) {
                            dp[l][x1][x2] = -1;
                        }
                        else {
                            dp[l][x1][x2] += prev;
                        }
                    }
                }
            }
        }
        return dp[n * 2][n][n] == -1 ? 0 : dp[n * 2][n][n];
    }
}