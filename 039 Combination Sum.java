/*
 * @Author: Hao Liu
 * @Date: 2019-08-18 10:49:52
 * @LastEditors: Hao Liu
 * @LastEditTime: 2019-08-18 10:50:01
 * @Description: DFS
 */

 class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();
        dfs(ans, comb, candidates, 0, target);
        return ans;
    }
    
    private void dfs(List<List<Integer>> ans, List<Integer> comb,
                    int[] candidates, int start, int target) {
        if (target == 0) {
            ans.add(new ArrayList<>(comb));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (target - candidates[i] < 0) continue;
            comb.add(candidates[i]);
            dfs(ans, comb, candidates, i, target - candidates[i]);
            comb.remove(comb.size() - 1);
        }
    }
}
