class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        int m = s1.length();
        int n = s2.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                int k = i + j;
                if (i == 0 && j == 0) continue;
                if (i == 0) {
                    dp[i][j] = s2.charAt(j - 1) == s3.charAt(k - 1) ? dp[i][j - 1] : false;
                }
                else if (j == 0) {
                    dp[i][j] = s1.charAt(i - 1) == s3.charAt(k - 1) ? dp[i - 1][j] : false;
                }
                else {
                    dp[i][j] = dp[i][j] || (s2.charAt(j - 1) == s3.charAt(k - 1) ? dp[i][j - 1] : false) || (s1.charAt(i - 1) == s3.charAt(k - 1) ? dp[i - 1][j] : false);
                }
            }
        }
        return dp[m][n];
    }
}