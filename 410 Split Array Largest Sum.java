class Solution {
    public int splitArray(int[] nums, int m) {
        if (nums == null || nums.length == 0 || m < 1) {
            return 0;
        }
        long sum = 0;
        long l = 0;
        long r = 0;
        for (int num : nums) {
            l = Math.max(l, num);
            r += num;
        }
        
        while (l < r) {
            long mid = l + (r - l) / 2;
            int count = split(nums, mid);
            if (count > m) {
                l = mid + 1;
            }
            else {
                r = mid;
            }
        }
        return (int) l;
    }
    
    private int split(int[] nums, long target) {
        int count = 1;
        long sum = 0;
        for (int num : nums) {
            if (sum + num > target) {
                count++;
                sum = 0;
            }
            sum += num;
        }
        return count;
    }
}