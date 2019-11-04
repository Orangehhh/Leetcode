class Solution {
    public int missingElement(int[] nums, int k) {
        int l = 0;
        int r = nums.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] - nums[0] - mid >= k) {
                r = mid;
            }
            else {
                l = mid + 1;
            }
        }
        return nums[l - 1] + k - (nums[l - 1] - nums[0] - (l - 1));
    }
}