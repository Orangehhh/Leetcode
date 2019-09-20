class Solution {
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) {
            return 0;
        }
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = Math.abs(i - j);
                }
                else {
                    dp[i][j] = dp[i - 1][j - 1] + 
                        (word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1);
                    dp[i][j] = Math.min(dp[i][j], 
                            Math.min(dp[i - 1][j], dp[i][j - 1]) + 1);
                }
            }
        }
        return dp[m][n];
    }
}