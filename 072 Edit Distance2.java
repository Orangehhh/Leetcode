class Solution {
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) {
            return 0;
        }
        int m = word1.length();
        int n = word2.length();
        mem = new int[m + 1][n + 1];
        return dp(word1, word2, m, n);
    }
    
    private int dp(String word1, String word2, int p1, int p2) {
        if (p1 == 0 || p2 == 0) {
            return mem[p1][p2] = Math.abs(p1 - p2);
        }
        if (mem[p1][p2] > 0) {
            return mem[p1][p2];
        }
        int ans = dp(word1, word2, p1 - 1, p2 - 1) + 
            (word1.charAt(p1 - 1) == word2.charAt(p2 - 1) ? 0 : 1);
        ans = Math.min(ans, 1 + Math.min(dp(word1, word2, p1, p2 - 1),
                             dp(word1, word2, p1 - 1, p2)));
        return mem[p1][p2] = ans;
    }
    
    private int[][] mem;
}