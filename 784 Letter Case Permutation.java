/*
 * @Author: Hao Liu
 * @Date: 2019-08-19 12:54:34
 * @LastEditors: Hao Liu
 * @LastEditTime: 2019-08-19 13:07:06
 * @Description: Backtracking
 */

class Solution {
    public List<String> letterCasePermutation(String S) {
        if (S == null || S.length() == 0) {
            return new ArrayList<>();
        }
        List<String> ans = new ArrayList<>();
        dfs(ans, S.toCharArray(), 0);
        return ans;
    }
    
    private void dfs(List<String> ans,
                     char[] chArr, int i) {
        if (i == chArr.length) {
            ans.add(new String(chArr));
            return;
        }
        dfs(ans, chArr, i + 1);
        if ((chArr[i] >= 'a' && chArr[i] <= 'z') 
            || (chArr[i] >= 'A' && chArr[i] <= 'Z')) {
            chArr[i] ^= (1 << 5);
            dfs(ans, chArr, i + 1);
            chArr[i] ^= (1 << 5);
        }
    }
}