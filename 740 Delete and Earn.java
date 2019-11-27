class Solution {
    public int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int[] count = new int[max + 1];
        for (int num : nums) {
            count[num]++;
        }
        int[] dp = new int[max + 1];
        dp[1] = count[1];
        for (int i = 2; i <= max; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + i * count[i]);
        }
        return dp[max];
    }
}