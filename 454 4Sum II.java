class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : A) {
            for (int b : B) {
                int sum = a + b;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        int ans = 0;
        for (int c : C) {
            for (int d : D) {
                int sum = c + d;
                ans += map.getOrDefault(-sum, 0);
            }
        }
        return ans;
    }
}