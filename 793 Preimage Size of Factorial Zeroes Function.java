class Solution {
    public int preimageSizeFZF(int K) {
        long lo = 0L;
        long hi = 10L * K + 1L;
        while (lo < hi) {
            long m = lo + (hi - lo) / 2;
            int count = zeta(m);
            if (count == K) return 5;
            else if (count > K) {
                hi = m;
            }
            else {
                lo = m + 1;
            }
        }
        return 0;
    }
    
    private int zeta(long x) {
        if (x == 0) return 0;
        return (int) (x / 5) + zeta(x / 5);
    }
}