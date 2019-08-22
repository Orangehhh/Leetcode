/*
 * @Author: Hao Liu
 * @Date: 2019-08-22 18:01:26
 * @LastEditors: Hao Liu
 * @LastEditTime: 2019-08-22 18:01:46
 * @Description: DFS, Similar to Word Break
 */

 class Solution {
    private Map<String, List<Integer>> mem;
    public List<Integer> diffWaysToCompute(String input) {
        mem = new HashMap<>();
        List<Integer> ans = dfs(input, 0, input.length() - 1);
        return ans;
    }
    
    private List<Integer> dfs(String input, int l, int r) {
        if (mem.containsKey(input.substring(l, r + 1))) {
            return mem.get(input.substring(l, r + 1));
        }
        if (input.substring(l, r + 1).matches("\\d+")) {
            List<Integer> tmp = new ArrayList<>();
            tmp.add(Integer.valueOf(input.substring(l, r + 1)));
            mem.put(input.substring(l, r + 1), tmp);
            return tmp;
        }
        List<Integer> tmp = new ArrayList<>();
        for (int k = l + 1; k < r; k++) {
            char ch = input.charAt(k);
            if (ch != '-' && ch != '+' && ch != '*')    continue;
            List<Integer> left = dfs(input, l, k - 1);
            List<Integer> right = dfs(input, k + 1, r);
            for (int leftNum : left) {
                for (int rightNum: right) {
                    if (ch == '-') {
                        tmp.add(leftNum - rightNum);
                    }
                    else if (ch == '+') {
                        tmp.add(leftNum + rightNum);
                    }
                    else if (ch == '*') {
                        tmp.add(leftNum * rightNum);
                    }
                    
                }
            }
        }
        mem.put(input.substring(l, r + 1), tmp);
        return tmp;
    }
}
