class Solution {
    private Boolean[][][] mem;
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        int l = s3.length();
        mem = new Boolean[m + 1][n + 1][l + 1];
        return dp(s1, s2, s3, 0, 0, 0);
    }
    
    private boolean dp(String s1, String s2, String s3, int i, int j, int k) {
        if (k == s3.length()) {
            if (i < s1.length() || j < s2.length()) {
                return false;
            }
            return true;
        }
        if (mem[i][j][k] != null) {
            return Boolean.valueOf(mem[i][j][k]);
        }
        boolean valid1 = false;
        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            valid1 = valid1 || dp(s1, s2, s3, i + 1, j, k + 1);
        }
        boolean valid2 = false;
        if (j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            valid2 = valid2 || dp(s1, s2, s3, i, j + 1, k + 1);
        }
        return mem[i][j][k] = valid1 || valid2;
    } 
}