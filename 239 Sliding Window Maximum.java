class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        Deque<Integer> dq = new LinkedList<>();
        initial(dq, nums, k);
        ans[0] = nums[dq.peekFirst()];
        for (int i = 1; i < ans.length; i++) {
            clean(dq, nums, i + k - 1, k);
            ans[i] = nums[dq.peekFirst()];
        }
        return ans;
    }
    
    private void initial(Deque<Integer> dq, int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            clean(dq, nums, i, k);
        }
    }
    
    private void clean(Deque<Integer> dq, int[] nums, int i, int k) {
        while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
            dq.pollFirst();
        }
        while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
            dq.pollLast();
        }
        dq.offerLast(i);
    }
}