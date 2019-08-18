/*
 * @Author: Hao Liu
 * @Date: 2019-08-18 11:44:04
 * @LastEditors: Hao Liu
 * @LastEditTime: 2019-08-18 11:44:35
 * @Description: Backtracking, Prune needed
 */

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        if (n == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();
        dfs(ans, comb, 1, n, k);
        return ans;
    }
    
    private void dfs(List<List<Integer>> ans, List<Integer> comb,
                    int s, int n, int k) {
        if (k == 0) {
            ans.add(new ArrayList<>(comb));
            return;
        }
        for (int i = s; i <= n - k + 1; i++) {
            // if (n - i + 1 + comb.size() < k)    continue;
            comb.add(i);
            dfs(ans, comb, i + 1, n, k - 1);
            comb.remove(comb.size() - 1);
        }
    }
}