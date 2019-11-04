class Solution {
    public boolean isPerfectSquare(int num) {
        if (num == 0)   return true;
        int l = 0;
        int r = num;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (Math.abs(mid - num * 1.0 / mid) <= 1e-9) {
                return true;
            }
            else if (mid - num * 1.0 / mid > 0) {
                r = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }
        return false;
    }
}