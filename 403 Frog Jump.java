class Solution {
    public boolean canCross(int[] stones) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0;i < stones.length; i++) {
            map.put(stones[i], i);
        }
        if (stones == null || stones.length == 0) {
            return true;
        }
        int n = stones.length;
        boolean[][] dp = new boolean[n][n + 1];
        dp[0][1] = true;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (dp[i][j] && map.containsKey(stones[i] + j)) {
                    int idx = map.get(stones[i] + j);
                    dp[idx][j - 1] = true;
                    dp[idx][j] = true;
                    dp[idx][j + 1] = true;
                }
            }
        }
        boolean ans = false;
        for (int i = 0; i < n; i++) {
            ans = ans || dp[n - 1][i];
        }
        return ans;
    }
}