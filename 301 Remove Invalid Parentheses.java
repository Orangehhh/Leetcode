class Solution {
    public List<String> removeInvalidParentheses(String s) {
        int n = s.length();
        int[] invalid = count(s);
        System.out.printf("%d, %d\n", invalid[0], invalid[1]);
        Set<String> ans = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        dfs(ans, sb, s, 0, 0, invalid[0], invalid[1]);
        return new ArrayList<>(ans);
    }
    
    private void dfs(Set<String> ans, StringBuilder sb, String s, int pos,
               int count, int leftInvalid, int rightInvalid) {
        if (count < 0 || leftInvalid < 0 || rightInvalid < 0) {
            return;
        }
        if (pos == s.length()) {
            if (count == 0 && leftInvalid == 0 && rightInvalid == 0) {
                ans.add(sb.toString());
            }
            return;
        }
        char ch = s.charAt(pos);
        if (ch == '(') {
            dfs(ans, sb, s, pos + 1, count, leftInvalid - 1, rightInvalid);
            sb.append(ch);
            dfs(ans, sb, s, pos + 1, count + 1, leftInvalid, rightInvalid);
            sb.deleteCharAt(sb.length() - 1);
        }
        else if (ch == ')') {
            dfs(ans, sb, s, pos + 1, count, leftInvalid, rightInvalid - 1);
            sb.append(ch);
            dfs(ans, sb, s, pos + 1, count - 1, leftInvalid, rightInvalid);
            sb.deleteCharAt(sb.length() - 1);
        }
        else {
            sb.append(ch);
            dfs(ans, sb, s, pos + 1, count, leftInvalid, rightInvalid);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    
    private int[] count(String s) {
        int left = 0;
        int right = 0;
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                count++;
            }
            else if (ch == ')') {
                count--;
            }
            if (count < 0) {
                right++;
                count = 0;
            }
        }
        left = count;
        return new int[]{left, right};
    }
}