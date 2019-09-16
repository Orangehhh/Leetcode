class Solution {
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] newNums = new int[n + 2];
        newNums[0] = 1;
        newNums[n + 1] = 1;
        for (int i = 1; i <= n; i++) {
            newNums[i] = nums[i - 1];
        }
        int[][] dp = new int[n + 2][n + 2];
        for (int l = 1; l <= n; l++) {
            for (int i = 1; i <= n - l + 1; i++) {
                int j = i + l - 1;
                for (int k = i; k <= j; k++) {
                    int score = dp[i][k - 1] + dp[k + 1][j] + newNums[k] * newNums[i - 1] * newNums[j + 1];
                    dp[i][j] = Math.max(dp[i][j], score);
                }
            }
        }
        return dp[1][n];
    }
}