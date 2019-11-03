class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1.0;
        double ans = 1.0;
        while (n > 1 || n < -1) {
            if (n % 2 != 0) {
                ans = ans * x;
            }
            n = n / 2;
            x = x * x;
        }
        if (n == 1) {
            return ans * x;
        }
        else {
            return 1.0 / (ans * x);
        }
    }
}