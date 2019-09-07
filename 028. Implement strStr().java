class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (isMatch(haystack, needle, i)) {
                return i;
            }
        }
        return -1;
    }
    
    private boolean isMatch(String s, String target, int pos) {
        for (int i = 0; i < target.length(); i++) {
            if (s.charAt(pos + i) != target.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}