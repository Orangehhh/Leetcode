class Solution {
    public int search(ArrayReader reader, int target) {
        if (reader.get(0) == Integer.MAX_VALUE) {
            return -1;
        }
        int l = 0;
        int r = 1;
        while (reader.get(r) < target) {
            l = r;
            r = r << 1;
        }
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int num = reader.get(mid);
            if (num == target) {
                return mid;
            }
            else if (num > target) {
                r = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }
        return -1;
    }
}