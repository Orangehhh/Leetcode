/*
 * @Author: Hao Liu
 * @Date: 2019-08-19 11:59:29
 * @LastEditors: Hao Liu
 * @LastEditTime: 2019-08-19 11:59:38
 * @Description: Backtracking
 */

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        if (n > 9 * k)  return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();
        dfs(ans, comb, k, n, 1);
        return ans;
    }
    
    private void dfs(List<List<Integer>> ans, List<Integer> comb,
                     int k, int n, int start) {
        if (comb.size() == k && n == 0) {
            ans.add(new ArrayList<>(comb));
            return;
        }
        for (int i = start; i <= 9; i++) {
            if (n - i < 0)  continue;
            comb.add(i);
            dfs(ans, comb, k, n - i, i + 1);
            comb.remove(comb.size() - 1);
        }
    }
}