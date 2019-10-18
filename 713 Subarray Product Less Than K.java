class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 0) {
            return 0;
        }
        int ans = 0;
        int l = 0;
        int product = 1;
        for (int r = 0; r < nums.length; r++) {
            product *= nums[r];
            while (l <= r && product >= k) {
                product /= nums[l++];
            }
            ans += r - l + 1;
        }
        return ans;
    }
}