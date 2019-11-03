class Solution {
    
    private int[] preSum;
    public Solution(int[] w) {
        preSum = new int[w.length];
        preSum[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            preSum[i] = preSum[i - 1] + w[i];
        }
    }
    
    public int pickIndex() {
        double num = Math.random() * preSum[preSum.length - 1];
        int l = 0;
        int r = preSum.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (preSum[mid] <= num) {
                l = mid + 1;
            }
            else {
                r = mid;
            }
        }
        return l;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */