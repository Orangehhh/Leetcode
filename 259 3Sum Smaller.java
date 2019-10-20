class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int ans = 0;
        int n = nums.length;
        for (int i = 0; i <= n - 2; i++) {
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                long total = (long) nums[i] + (long) nums[j] + (long) nums[k];
                if (total < target) {
                    ans += k - j;
                    j++;
                }
                else {
                    k--;
                }
            }
        }
        return ans;
    }
}