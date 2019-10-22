class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int n = nums.length;
        int[] ans = new int[n];
        int l = 0;
        int r = n - 1;
        int idx = n - 1;
        if (a == 0) {
            while (l <= r) {
                int yl = f(nums[l], a, b, c);
                int yr = f(nums[r], a, b, c);
                if (yl >= yr) {
                    ans[idx--] = yl;
                    l++;
                }
                else {
                    ans[idx--] = yr;
                    r--;
                }
            }
        }
        else {
            double x = -b * 0.5 / a;
            if (a > 0) {
                while (l <= r) {
                    if (Math.abs(nums[l] - x) >= Math.abs(nums[r] - x)) {
                        ans[idx--] = f(nums[l], a, b, c);
                        l++;
                    }
                    else {
                        ans[idx--] = f(nums[r], a, b, c);
                        r--;
                    }
                }
            }
            else {
                idx = 0;
                while (l <= r) {
                    if (Math.abs(nums[l] - x) >= Math.abs(nums[r] - x)) {
                        ans[idx++] = f(nums[l], a, b, c);
                        l++;
                    }
                    else {
                        ans[idx++] = f(nums[r], a, b, c);
                        r--;
                    }
                }
            }
        }
        return ans;
    }
    
    private int f(int x, int a, int b, int c) {
        return a * x * x + b * x + c;
    }
}