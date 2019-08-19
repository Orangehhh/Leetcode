/*
 * @Author: Hao Liu
 * @Date: 2019-08-19 10:58:30
 * @LastEditors: Hao Liu
 * @LastEditTime: 2019-08-19 10:58:43
 * @Description: Backtracking
 */

 class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length; i++) {
            dfs(ans, comb, nums, 0, i);
        }
        return ans;
    }
    
    private void dfs(List<List<Integer>> ans, List<Integer> comb,
                    int[] nums, int start, int n) {
        if (comb.size() == n) {
            ans.add(new ArrayList<>(comb));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1])    continue;
            comb.add(nums[i]);
            dfs(ans, comb, nums, i + 1, n);
            comb.remove(comb.size() - 1);
        }
    }
}
