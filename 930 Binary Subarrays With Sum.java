class Solution {
    public int numSubarraysWithSum(int[] A, int S) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int n = A.length;
        int ans = 0;
        int[] count = new int[n + 1];
        count[0] = 1;
        int sum = 0;
        for (int num : A) {
            sum += num;
            if (sum >= S)   ans += count[sum - S];
            count[sum]++;
        }
        return ans;
    }
}