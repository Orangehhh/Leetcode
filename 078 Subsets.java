/*
 * @Author: Hao Liu
 * @Date: 2019-08-19 10:33:19
 * @LastEditors: Hao Liu
 * @LastEditTime: 2019-08-19 10:33:29
 * @Description: Backtracking
 */

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();
        dfs(ans, comb, nums, 0);
        return ans;
    }
    
    private void dfs(List<List<Integer>> ans, 
                     List<Integer> comb,
                     int[] nums, int start) {
        ans.add(new ArrayList<>(comb));
        for (int i = start; i < nums.length; i++) {
            comb.add(nums[i]);
            dfs(ans, comb, nums, i + 1);
            comb.remove(comb.size() - 1);
        }
    }
}