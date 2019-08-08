/*
 * @Author: Hao Liu
 * @Date: 2019-08-07 23:26:59
 * @LastEditors: Hao Liu
 * @LastEditTime: 2019-08-07 23:32:59
 * @Description: Multiplication of two big numbers (in String format)
 */

class Solution {
    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0) {
            return "";
        }
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int m = num1.length();
        int n = num2.length();
        StringBuilder sb = new StringBuilder();
        int[] digit = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = digit[i + j + 1] + mul;
                digit[i + j + 1] = sum % 10;
                digit[i + j] += sum / 10;
            }
        }
        for (int i : digit) {
            if (!(sb.length() == 0 && i == 0)) {
                sb.append(i);
            }
        }
        return sb.toString();
    }
}