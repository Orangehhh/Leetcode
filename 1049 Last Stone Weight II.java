class Solution {
    public int lastStoneWeightII(int[] stones) {
        if (stones == null || stones.length == 0) {
            return 0;
        }
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        int n = stones.length;
        boolean[][] dp = new boolean[n + 1][sum + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (j + stones[i - 1] <= sum && dp[i - 1][j + stones[i - 1]] ||
                   dp[i - 1][Math.abs(j - stones[i - 1])]) {
                    dp[i][j] = true;
                }
            }
        }
        for (int j = 0; j <= sum; j++) {
            if (dp[n][j]) {
                return j;
            }
        }
        return sum;
    }
}