class Solution {
    private int kMod = 1000000007;
    public int knightDialer(int N) {
        int[][] neighbors = {{4, 6}, {8, 6}, {7, 9}, {4, 8}, {0, 3, 9},
                             {}, {0, 1, 7}, {2, 6}, {1, 3}, {2, 4}};
        int[][] dp = new int[N + 1][10];
        for (int j = 0; j < 10; j++) {
            dp[1][j] = 1;
        }
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 10; j++) {
                for (int nei : neighbors[j]) {
                    dp[i + 1][nei] += dp[i][j];
                    dp[i + 1][nei] %= kMod;
                }
            }
        }
        int ans = 0;
        for (int j = 0; j < 10; j++) {
            ans += dp[N][j];
            ans %= kMod;
        }
        return ans;
    }
}