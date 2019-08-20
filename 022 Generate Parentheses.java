/*
 * @Author: Hao Liu
 * @Date: 2019-08-19 19:30:26
 * @LastEditors: Hao Liu
 * @LastEditTime: 2019-08-19 19:30:37
 * @Description: Backtracking
 */

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(ans, sb, n, 0);
        return ans;
    }
    
    private void dfs(List<String> ans, StringBuilder sb, int n, int count) {
        if (sb.length() == n * 2) {
            if (count == 0) {
                ans.add(sb.toString());
            }
            return;
        }
        if (count < n) {
            sb.append('(');
            dfs(ans, sb, n, count + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (count > 0) {
            sb.append(')');
            dfs(ans, sb, n, count - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}