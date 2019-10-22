class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int countOne = 0;
        int i = 0;
        int ans = 0;
        for (int j = 0; j < n; j++) {
            countOne += nums[j];
            while (j - i + 1 - countOne > 1) {
                countOne -= nums[i++];
            }
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }
}