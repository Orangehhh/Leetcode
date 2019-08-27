/*
 * @Author: Hao Liu
 * @Date: 2019-08-27 09:57:11
 * @LastEditors: Hao Liu
 * @LastEditTime: 2019-08-27 09:57:37
 * @Description: HashMap
 */

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            if (map.containsKey(num)) {
                ans[0] = map.get(num);
                ans[1] = i;
                return ans;
            }
            else {
                map.put(nums[i], i);
            }
        }
        return new int[] {-1, -1};
     }
}