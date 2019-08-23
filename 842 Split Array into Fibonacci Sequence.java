/*
 * @Author: Hao Liu
 * @Date: 2019-08-23 10:28:35
 * @LastEditors: Hao Liu
 * @LastEditTime: 2019-08-23 10:28:52
 * @Description: DFS, Similar to LC 282
 */

 class Solution {
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> ans = new ArrayList<>();
        dfs(ans, -1, -1, S, 0);
        return ans;
    }
    
    private boolean dfs(List<Integer> ans, long prevprev, long prev, String S, int pos) {
        if (pos == S.length()) {
            if (ans.size() >= 3) {
                return true;
            }
            return false;
        }
        int s = pos;
        long n = 0;
        while (pos < S.length()) {
            if (S.charAt(s) == '0' && pos > s)  break;
            n = n * 10 + (S.charAt(pos) - '0');
            if (n > Integer.MAX_VALUE)  break;
            pos++;
            if (ans.size() >= 2 && n != prevprev + prev)   continue;
            ans.add((int) n);
            if (dfs(ans, prev, n, S, pos))  return true;
            ans.remove(ans.size() - 1);
        }
        return false;
    }
}
