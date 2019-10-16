class Solution {
    public void sortColors(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int cur = l;
        while (cur <= r) {
            if (nums[cur] == 0) {
                nums[cur++] = nums[l];
                nums[l++] = 0;
            }
            else if (nums[cur] == 2) {
                nums[cur] = nums[r];
                nums[r--] = 2;
            }
            else {
                cur++;
            }
        }
    }
}