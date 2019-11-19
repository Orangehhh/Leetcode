class Solution {
    public int mctFromLeafValues(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int n = arr.length;
        int[][] dp = new int[n][n];
        int[][] max = new int[n][n];
        for (int l = 1; l <= n; l++) {
            for (int i = 0; i <= n - l; i++) {
                int j = i + l - 1;
                if (l == 1) {
                    dp[i][j] = 0;
                    max[i][j] = arr[i];
                }
                else {
                    dp[i][j] = Integer.MAX_VALUE;
                    max[i][j] = Math.max(max[i][j - 1], arr[j]);
                    for (int k = i; k < j; k++) {
                        dp[i][j] = Math.min(dp[i][j], 
                                dp[i][k] + dp[k + 1][j] + 
                                            max[i][k] * max[k + 1][j]);
                    }
                }
            }
        }
        return dp[0][n - 1];
    }
}