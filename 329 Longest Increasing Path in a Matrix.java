class Solution {
    private int[] dirs = {-1, 0, 1, 0, -1};
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, dfs(matrix, i, j, dp));
            }
        }
        return ans;
    }
    
    private int dfs(int[][] matrix, int i, int j, int[][] dp) {
        if (dp[i][j] > 0) return dp[i][j];
        int len = 0;
        for (int k = 0; k < 4; k++) {
            int r = i + dirs[k];
            int c = j + dirs[k + 1];
            if (r < 0 || r >= matrix.length || c < 0 || c >= matrix[0].length ||
               matrix[r][c] <= matrix[i][j])    continue;
            len = Math.max(len, dfs(matrix, r, c, dp));
        }
        return dp[i][j] = len + 1;
    }
}