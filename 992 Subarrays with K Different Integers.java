class Solution {
    public int subarraysWithKDistinct(int[] A, int K) {
        return atMostK(A, K) - atMostK(A, K - 1);
    }
    
    private int atMostK(int[] A, int K) {
        if (A == null || A.length < K || K <= 0) {
            return 0;
        }
        int i = 0;
        int ans = 0;
        int[] count = new int[A.length + 1];
        int k = 0;
        for (int j = 0; j < A.length; j++) {
            if (count[A[j]] == 0)   k++;
            count[A[j]]++;
            while (k > K) {
                count[A[i]]--;
                if (count[A[i]] == 0) {
                    k--;
                }
                i++;
            }
            ans += j - i + 1;
        }
        return ans;
    }
}