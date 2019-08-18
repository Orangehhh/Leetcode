/*
 * @Author: Hao Liu
 * @Date: 2019-08-18 01:01:38
 * @LastEditors: Hao Liu
 * @LastEditTime: 2019-08-18 01:01:48
 * @Description: DFS
 */

 class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        List<String> ans = new ArrayList<>();
        String[] map = {" ", "", "abc", "def", "ghi", "jkl", 
                        "mno", "pqrs", "tuv", "wxyz"};
        StringBuilder comb = new StringBuilder();
        dfs(ans, comb, map, digits, 0);
        return ans;
    }
    
    private void dfs(List<String> ans, StringBuilder comb, String[] map, String digits, int start) {
        if (start == digits.length()) {
            ans.add(comb.toString());
            return;
        }
        for (char ch : map[digits.charAt(start) - '0'].toCharArray()) {
            comb.append(ch);
            dfs(ans, comb, map, digits, start + 1);
            comb.deleteCharAt(comb.length() - 1);
        }
    }
}
