class Solution {
    public String fractionToDecimal(int numerator1, int denominator1) {
        if (denominator1 == 0) {
            return "";
        }
        if (numerator1 == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        int sign = 1;
        if (numerator1 < 0 && denominator1 > 0 ||
           numerator1 > 0 && denominator1 < 0) {
            sign = -1;
        }
        long numerator = Math.abs((long) numerator1);
        long denominator = Math.abs((long) denominator1);
        if (sign == -1) {
            sb.append("-");
        }
        long quotient = numerator / denominator;
        long rem = numerator - quotient * denominator;
        numerator = rem;
        sb.append(quotient);
        if (numerator != 0) {
            sb.append(".");
            int start = sb.length();
            Map<Long, Integer> map = new HashMap<>();
            int count = 1;
            while (true) {
                if (numerator == 0) break;
                if (map.containsKey(numerator)) {
                    sb.insert(start + map.get(numerator) - 1, "(");
                    sb.append(")");
                    break;
                }
                else {
                    map.put(numerator, count);
                    numerator *= 10;
                    quotient = numerator / denominator;
                    rem = numerator - quotient * denominator;
                    numerator = rem;
                    sb.append(quotient);
                }
                count++;
            }
        }
        return sb.toString();
    }
}