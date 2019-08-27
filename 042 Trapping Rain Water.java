/*
 * @Author: Hao Liu
 * @Date: 2019-08-27 14:30:00
 * @LastEditors: Hao Liu
 * @LastEditTime: 2019-08-27 14:30:09
 * @Description: Two Pointers
 */

 class Solution {
    public int trap(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int ans = 0;
        int maxHeight = 0;
        while (l < r) {
            while (l < r && height[l] <= height[r]) {
                maxHeight = Math.max(maxHeight, height[l]);
                ans += maxHeight - height[l] > 0 ? maxHeight - height[l] : 0;
                l++;
            }
            while (l < r && height[l] > height[r]) {
                maxHeight = Math.max(maxHeight, height[r]);
                ans += maxHeight - height[r] > 0 ? maxHeight - height[r] : 0;
                r--;
            }
        }
        return ans;
    }
}
