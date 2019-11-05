class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int ans = 0;
        int n = heaters.length;
        for (int house : houses) {
            int idx = findPosition(house, heaters);
            int d1 = idx < n ? heaters[idx] - house : Integer.MAX_VALUE;
            int d2 = idx > 0 ? house - heaters[idx - 1] : Integer.MAX_VALUE;
            ans = Math.max(ans, Math.min(d1, d2));
        }
        return ans;
    }
    
    private int findPosition(int house, int[] heaters) {
        int l = 0;
        int r = heaters.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (heaters[mid] < house) {
                l = mid + 1;
            }
            else {
                r = mid;
            }
        }
        return l;
    }
}