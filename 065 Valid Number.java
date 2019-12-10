class Solution {
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        int i = 0;
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        } 
        if (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            i++;
        }
        boolean hasInteger = false;
        while (i < s.length() && isDigit(s.charAt(i))) {
            hasInteger = true;
            i++;
        }
        boolean hasDecimal = false;
        if (i < s.length() && s.charAt(i) == '.') {
            i++;
            while (i < s.length() && isDigit(s.charAt(i))) {
                hasDecimal = true;
                i++;
            }
        }
        if (!hasInteger && !hasDecimal) return false;
        if (i < s.length() && s.charAt(i) == 'e') {
            i++;
            if (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
                i++;
            }
            if (i == s.length() || !isDigit(s.charAt(i))) {
                return false;
            }
            while (i < s.length() && isDigit(s.charAt(i))) {
                i++;
            }
        }
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }
        return i == s.length();
    }
    
    private boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }
}