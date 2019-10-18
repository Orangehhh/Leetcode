class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int ans = n + 1;
        int l = 0;
        int sum = 0;
        for (int r = 0; r < n; r++) {
            sum += nums[r];
            while (sum >= s && l <= r) {
                ans = Math.min(ans, r - l + 1);
                sum -= nums[l++];
            }
        }
        return ans == n + 1 ? 0 : ans;
    }
}