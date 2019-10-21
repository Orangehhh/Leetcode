class Solution {
    public boolean circularArrayLoop(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0 || goToNext(i, nums) == i)    continue;
            int slow = i;
            int fast = i;
            while (nums[i] > 0 && nums[fast] > 0 ||
                  nums[i] < 0 && nums[fast] < 0) {
                slow = goToNext(slow, nums);
                fast = goToNext(fast, nums);
                if (nums[i] > 0 && nums[fast] < 0 || 
                   nums[i] < 0 && nums[fast] > 0) break;
                fast = goToNext(fast, nums);
                if (slow == fast) {
                    if (slow != goToNext(fast, nums)) {
                        System.out.println(i);
                        return true;
                    }
                    break;
                }
            }
        }
        return false;
    }
    
    private int goToNext(int idx, int[] nums) {
        int n = nums.length;
        return ((idx + nums[idx]) % n + n) % n;
    }
}