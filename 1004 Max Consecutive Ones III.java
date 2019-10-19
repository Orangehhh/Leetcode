class Solution {
    public int longestOnes(int[] A, int K) {
        if (A == null || A.length == 0 || K < 0) {
            return 0;
        }
        int n = A.length;
        int i = 0;
        int replaced = 0;
        int ans = 0;
        for (int j = 0; j < n; j++) {
            if (A[j] == 0) {
                replaced++;
                while (i <= j && replaced > K) {
                    if (A[i++] == 0) replaced--;
                }
            }
            ans = Math.max(ans, j - i + 1);
        } 
        return ans;
    }
}