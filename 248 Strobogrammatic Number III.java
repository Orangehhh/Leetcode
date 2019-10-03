class Solution {
    
    private static char[][] pairs = new char[][] 
        {{'0', '0'}, {'1', '1'}, {'6', '9'}, {'8', '8'}, {'9', '6'}};
    
    public int strobogrammaticInRange(String low, String high) {
        if (low == null || high == null || low.length() > high.length() ||
            low.length() == high.length() && low.compareTo(high) > 0) {
            return 0;
        }
        int count = 0;
        for (int i = low.length(); i <= high.length(); i++) {
            count += dfs(low, high, new char[i], 0, i - 1);
        }
        return count;
    }
    
    private int dfs(String low, String high, char[] ch, int left, int right) {
        if (left > right) {
            String s = new String(ch);
            if (s.length() == low.length() && s.compareTo(low) < 0 ||
                s.length() == high.length() && s.compareTo(high) > 0) {
                return 0;
            }
            return 1;
        }
        int count = 0;
        for (char[] p : pairs) {
            ch[left] = p[0];
            ch[right] = p[1];
            if (ch.length != 1 && ch[0] == '0') {
                continue;
            }
            if (left == right && (ch[left] == '6' || ch[right] == '9')) {
                continue;
            }
            count += dfs(low, high, ch, left + 1, right - 1);
        }
        return count;
    }
}