class Solution {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target)    return true;
            if (nums[l] >= nums[r]) {
                if (nums[l] == nums[r] && nums[mid] == nums[l])   r--;
                else if (nums[mid] >= nums[l]) {
                    if (nums[mid] > target && target >= nums[l]) {
                        r = mid - 1;
                    }
                    else {
                        l = mid + 1;
                    }
                }
                else {
                    if (nums[mid] < target && target <= nums[r]) {
                        l = mid + 1;
                    }
                    else {
                        r = mid - 1;
                    }
                }
            }
            else if (nums[l] < nums[r]) {
                if (nums[mid] < target) {
                    l = mid + 1;
                }
                else {
                    r = mid - 1;
                }
            }
        }
        return false;
    }
}