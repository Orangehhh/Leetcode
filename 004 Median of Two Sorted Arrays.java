/*
 * @Author: Hao Liu
 * @Date: 2019-08-27 12:14:01
 * @LastEditors: Hao Liu
 * @LastEditTime: 2019-08-27 12:14:29
 * @Description: Binary Search
 */

 class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n)  return findMedianSortedArrays(nums2, nums1);
        int k = (m + n + 1) / 2;
        int l = 0;
        int r = m;
        while (l < r) {
            int x = l + (r - l) / 2;
            int y = k - x;
            if (nums1[x] < nums2[y - 1]) {
                l = x + 1;
            }
            else {
                r = x;
            }
        }
        int x = l;
        int y = k - x;
        int c1 = Math.max(x <= 0 ? Integer.MIN_VALUE : nums1[x - 1], 
                          y <= 0 ? Integer.MIN_VALUE : nums2[y - 1]);
        if ((m + n) % 2 == 1) {
            return (double) c1;
        }
        else {
            int c2 = Math.min(x >= m ? Integer.MAX_VALUE : nums1[x], 
                              y >= n ? Integer.MAX_VALUE : nums2[y]);
            return (c1 + c2) * 1.0 / 2;
        }
    }
}
