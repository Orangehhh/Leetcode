class Solution {
    public int[] sortedSquares(int[] A) {
        if (A == null || A.length == 0) {
            return A;
        }
        int n = A.length;
        int[] ans = new int[n];
        int idx = n - 1;
        int l = 0;
        int r = n - 1;
        while (l <= r) {
            if (Math.abs(A[l]) >= Math.abs(A[r])) {
                ans[idx--] = A[l] * A[l];
                l++;
            }
            else {
                ans[idx--] = A[r] * A[r];
                r--;
            }
        }
        return ans;
    }
}