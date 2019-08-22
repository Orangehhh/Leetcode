/*
 * @Author: Hao Liu
 * @Date: 2019-08-22 16:41:57
 * @LastEditors: Hao Liu
 * @LastEditTime: 2019-08-22 16:42:16
 * @Description: DFS
 */

 class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(ans, sb, 4, s, 0);
        return ans;
    }
    
    private void dfs(List<String> ans, StringBuilder sb, int k, String s, int start) {
        if (k == 0) {
            if (start == s.length()) {
                ans.add(sb.substring(0, sb.length() - 1).toString());
            }
            return;
        }
        for (int j = start + 1; j <= s.length() && j <= start + 3; j++) {
            String str = s.substring(start, j);
            if (str.length() > 1 && str.charAt(0) == '0')   continue;
            if (Integer.valueOf(str) > 255) continue;
            sb.append(str);
            sb.append(".");
            dfs(ans, sb, k - 1, s, j);
            sb.delete(sb.length() - 1 - str.length(), sb.length());
        }
    }
}
