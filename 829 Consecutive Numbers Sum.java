class Solution {
    public int consecutiveNumbersSum(int N) {
        int ans = 0;
        for (int n = 1; 2 * N / n - n + 1 >= 2; n++) {
            if (2 * N % n == 0 && (2 * N / n - n + 1) % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }
}