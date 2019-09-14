class Solution {
    public boolean isMatch(String s, String p) {
        mem = new Boolean[s.length() + 1][p.length() + 1];
        return dp(s, p, 0, 0);
    }
    
    private boolean dp(String s, String p, int i, int j) {
        if (j == p.length()) {
            return i == s.length() ? true : false;
        }
        if (i == s.length() + 1) {
            return false;
        }
        if (mem[i][j] != null) {
            return Boolean.valueOf(mem[i][j]);
        }
        boolean firstMatch = false;
        if (i < s.length() && s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
            firstMatch = true;
        }
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            mem[i][j] = dp(s, p, i, j + 2) || 
                (firstMatch && dp(s, p, i + 1, j));
        }
        else {
            mem[i][j] = firstMatch && dp(s, p, i + 1, j + 1);
        }
        return mem[i][j];
    } 
    
    private Boolean[][] mem;
}