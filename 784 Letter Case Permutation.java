/*
 * @Author: Hao Liu
 * @Date: 2019-08-19 12:54:34
 * @LastEditors: Hao Liu
 * @LastEditTime: 2019-08-19 12:54:49
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

        if (chArr[i] >= '0' && chArr[i] <= '9') {
            dfs(ans, chArr, i + 1);
            return;
        }
             
        chArr[i] = Character.toLowerCase(chArr[i]);
        dfs(ans, chArr, i + 1);
            
        chArr[i] = Character.toUpperCase(chArr[i]);
        dfs(ans, chArr, i + 1);
    }
}