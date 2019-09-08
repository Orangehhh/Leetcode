class Solution {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int ans = 0;
        int sign = 1;
        int i = 0;
        while (i < str.length() && str.charAt(i) == ' ') {
            i++;
        }
        if (i >= str.length())   return ans;
        if (str.charAt(i) == '+') {
            i++;
        }
        else if (str.charAt(i) == '-') {
            sign = -1;
            i++;
        }
        while (i < str.length()) {
            char ch = str.charAt(i);
            if (ch > '9' || ch < '0')   break;
            if (sign == 1 && ans > (Integer.MAX_VALUE - (ch - '0')) / 10) {
                return Integer.MAX_VALUE;
            }
            if (sign == -1 && -ans < (Integer.MIN_VALUE + (ch - '0')) / 10) {
                return Integer.MIN_VALUE;
            }
            ans = 10 * ans + (ch - '0');
            i++;
        }
        return sign * ans;
    }
}