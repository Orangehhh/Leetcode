/*
 * @Author: Hao Liu
 * @Date: 2019-08-23 10:10:51
 * @LastEditors: Hao Liu
 * @LastEditTime: 2019-08-23 10:11:02
 * @Description: DFS
 */

 class Solution {
    private char[] exp;
    private List<String> ans;
    public List<String> addOperators(String num, int target) {
        int n = num.length();
        this.exp = new char[2 * n];
        this.ans = new ArrayList<>();
        dfs(num, 0, 0, 0, target, 0);
        return ans;
    }
    
    private void dfs(String num, long prev, long cur, int pos, int target, int len) {
        if (pos == num.length()) {
            if (cur == target) {
                ans.add(new String(exp, 0, len));
            }
            return;
        }
        int l = len;
        int s = pos;
        if (s != 0) {
            len++;
        }
        long n = 0;
        while (pos < num.length()) {
            if (num.charAt(s) == '0' && pos > s)   break;
            n = n * 10 + num.charAt(pos) - '0';
            if (n > Integer.MAX_VALUE)  break;
            exp[len++] = num.charAt(pos);
            pos++;
            if (s == 0) {
                dfs(num, n, n, pos, target, len);
                continue;
            }
            exp[l] = '+';
            dfs(num, n, cur + n, pos, target, len);
            exp[l] = '-';
            dfs(num, -n, cur - n, pos, target, len);
            exp[l] = '*';
            dfs(num, prev * n, cur - prev + prev * n, pos, target, len);
        }
    }
}
