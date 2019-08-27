/*
 * @Author: Hao Liu
 * @Date: 2019-08-27 14:11:14
 * @LastEditors: Hao Liu
 * @LastEditTime: 2019-08-27 14:11:29
 * @Description: Two Pointers
 */

 class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1])    continue;
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[j] + nums[k] + nums[i];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                }
                else if (nums[j] + nums[k] > -nums[i]) {
                    k--;
                }
                else {
                    j++;
                }
            }
        }
        return ans;
    }
}
