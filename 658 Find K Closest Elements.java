class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        int p = findPosition(arr, x);
        int l = p - k >= 0 ? p - k : 0;
        int r = p + k - 1 < n ? p + k - 1 : n - 1;
        while (r - l + 1 > k) {
            if (Math.abs(arr[l] - x) > Math.abs(arr[r] - x)) {
                l++;
            }
            else {
                r--;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = l; i <= r; i++) {
            ans.add(arr[i]);
        }
        return ans;
    }
    
    private int findPosition(int[] arr, int x) {
        int l = 0;
        int r = arr.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] >= x) {
                r = mid;
            }
            else {
                l = mid + 1;
            }
        }
        return l;
    }
}