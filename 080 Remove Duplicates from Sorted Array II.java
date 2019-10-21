class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int i = 1;
        int cnt = 1;
        for (int j = 1; j < n; j++) {
            if (nums[j] != nums[i - 1] || cnt < 2) {
                nums[i] = nums[j];
                if (nums[j] != nums[i - 1]) {
                    cnt = 1;
                }
                else {
                    cnt++;
                }
                i++;
            }
        }
        return i;
    }
}