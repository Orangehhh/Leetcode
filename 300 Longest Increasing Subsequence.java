class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n];
        int len = 0;
        for (int num : nums) {
            int idx = Arrays.binarySearch(dp, 0, len, num);
            if (idx < 0) {
                idx = -(idx + 1);
            }
            if (idx == len) {
                len++;
            }
            dp[idx] = num;
        }
        return len;
    }
}