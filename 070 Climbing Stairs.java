class Solution {
    public int climbStairs(int n) {
        if (n < 2) {
            return 1;
        }
        int prevTwo = 1;
        int prevOne = 1;
        for (int i = 2; i <= n; i++) {
            int tmp = prevTwo + prevOne;
            prevTwo = prevOne;
            prevOne = tmp;
        }
        return prevOne;
    }
}