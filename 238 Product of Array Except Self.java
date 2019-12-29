class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int n = nums.length;
        int[] ans = new int[n];
        ans[0] = 1;
        for (int i = 1; i < n; i++) {
            ans[i] = nums[i - 1] * ans[i - 1];
        }
        int r = 1;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] = ans[i] * r;
            r = r * nums[i];
        }
        return ans;
    }
}