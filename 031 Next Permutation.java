class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int n = nums.length;
        int i = n - 1;
        while (i > 0) {
            if (nums[i] > nums[i - 1]) {
                break;
            }
            i--;
        }
        if (i == 0) {
            reverse(nums, 0, n - 1);
        }
        else {
            int pos = n - 1;
            while (nums[pos] <= nums[i - 1]) {
                pos--;
            }
            swap(nums, i - 1, pos);
            reverse(nums, i, n - 1);
        }
    }
    
    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}