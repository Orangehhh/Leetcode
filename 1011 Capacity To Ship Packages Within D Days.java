class Solution {
    public int shipWithinDays(int[] weights, int D) {
        if (weights == null || weights.length == 0) {
            return 0;
        }
        int l = 0;
        int r = Integer.MAX_VALUE;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (check(mid, weights, D)) {
                r = mid;
            }
            else {
                l = mid + 1;
            }
        }
        return l;
    }
    
    private boolean check(int mid, int[] weights, int D) {
        int count = 1;
        int sum = 0;
        for (int weight : weights) {
            if (weight > mid)   return false;
            if (sum + weight <= mid) {
                sum += weight;
            }
            else {
                count++;
                sum = weight;
            }
        }
        return count <= D;
    }
}