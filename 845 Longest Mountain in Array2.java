class Solution {
    public int longestMountain(int[] A) {
        if (A == null || A.length < 3) {
            return 0;
        }
        int ans = 0;
        int base = -1;
        int idx = 0;
        int n = A.length;
        while (idx < n) {
            if (idx + 1 < n && A[idx] < A[idx + 1]) {
                base = idx;
                while (idx + 1 < n && A[idx] < A[idx + 1]) {
                    idx++;
                }
                if (idx + 1 < n && A[idx] > A[idx + 1]) {
                    while (idx + 1 < n && A[idx] > A[idx + 1]) {
                        idx++;
                    }
                    if (base != -1) {
                        ans = Math.max(ans, idx - base + 1);
                    }
                }
            }
            if (base == -1) {
                idx++;
            }
            else {
                base = -1;
            }
        }
        return ans;
    }
}