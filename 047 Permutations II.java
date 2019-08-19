/*
 * @Author: Hao Liu
 * @Date: 2019-08-19 12:26:51
 * @LastEditors: Hao Liu
 * @LastEditTime: 2019-08-19 12:27:12
 * @Description: Backtracking, Permutation, Remove duplicates
 */

 class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        boolean[] used = new boolean[n];
        dfs(ans, comb, nums, used);
        return ans;
    }
    
    private void dfs(List<List<Integer>> ans, List<Integer> comb,
                    int[] nums, boolean[] used) {
        if (comb.size() == nums.length) {
            ans.add(new ArrayList<>(comb));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i])  continue;
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            comb.add(nums[i]);
            used[i] = true;
            dfs(ans, comb, nums, used);
            comb.remove(comb.size() - 1);
            used[i] = false;
        }
    }
}
