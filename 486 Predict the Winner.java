class Solution {
    
    private Integer[][] mem;
    
    public boolean PredictTheWinner(int[] nums) {
        if (nums == null || nums.length < 2) {
            return true;
        }
        int n = nums.length;
        mem = new Integer[n][n];
        return dp(nums, 0, n - 1) >= 0;
    }
    
    private int dp(int[] nums, int start, int end) {
        if (start == end) {
            return mem[start][end] = new Integer(nums[start]);
        }
        if (mem[start][end] != null) {
            return Integer.valueOf(mem[start][end]);
        }
        return mem[start][end] = 
            Math.max(nums[start] - dp(nums, start + 1, end), 
                     nums[end] - dp(nums, start, end - 1));
    }
}