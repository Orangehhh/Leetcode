/*
 * @Author: Hao Liu
 * @Date: 2019-08-22 17:10:38
 * @LastEditors: Hao Liu
 * @LastEditTime: 2019-08-22 17:10:48
 * @Description: DFS
 */

class Solution {
    private int[][] mem;
    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }
        mem = new int[s.length() + 1][s.length() + 1];
        List<List<String>> ans = new ArrayList<>();
        List<String> comb = new ArrayList<>();
        dfs(ans, comb, s, 0);
        return ans;
    }
    
    private void dfs(List<List<String>> ans, List<String> comb, String s, int start) {
        if (start == s.length()) {
            ans.add(new ArrayList<>(comb));
            return;
        }
        for (int i = start + 1; i <= s.length(); i++) {
            String str = s.substring(start, i);
            if (isPalindrome(s, start, i - 1) == 2) continue;
            comb.add(str);
            dfs(ans, comb, s, i);
            comb.remove(comb.size() - 1);
        }
    }
    
    private int isPalindrome(String s, int l, int r) {
        if (l >= r) {
            return 1;
        }
        if (mem[l][r] > 0) {
            return mem[l][r];
        }
        if (s.charAt(l) != s.charAt(r)) {
            return mem[l][r] = 2;
        }
        return mem[l][r] = isPalindrome(s, l + 1, r - 1);
    }
}