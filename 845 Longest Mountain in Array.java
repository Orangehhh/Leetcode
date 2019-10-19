class Solution {
    public int longestMountain(int[] A) {
        if (A == null || A.length < 3) {
            return 0;
        }
        int l = 0;
        int r = 1;
        int asc = 0;
        int ans = 0;
        while (r < A.length) {
            if (A[r] == A[r - 1]) {
                l = r;
                asc = 0;
            }
            else if (A[r] < A[r - 1]) {
                if (asc == 1) {
                    asc = 2;
                }
                else if (asc == 0) {
                    l = r;
                }
            }
            else if (A[r] > A[r - 1]) {
                if (asc == 0) {
                    asc = 1;
                }
                else if (asc == 2) {
                    l = r - 1;
                    r--;
                    asc = 1;
                }
            }
            if (asc == 2) {
                ans = Math.max(ans, r - l + 1);
            }
            r++;
        }
        return ans;
    }
}