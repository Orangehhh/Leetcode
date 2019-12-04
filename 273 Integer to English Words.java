class Solution {
    String[] digit = {"One", "Two", "Three", "Four", "Five", "Six", "Seven",
                     "Eight", "Nine"};
    String[] second = {"Twenty ", "Thirty " ,"Forty ", "Fifty ", "Sixty ", 
                       "Seventy ", "Eighty ", "Ninety "};
    String[] sp = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen",
                  "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] m = {"", " Thousand ", " Million ", " Billion ", " Trillion "};
    public String numberToWords(int num) {
        if (num == 0)   return "Zero";
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (num > 0) {
            int lastThree = num % 1000;
            num /= 1000;
            if (lastThree != 0) {
                String str = helper(lastThree);
                sb.insert(0, trim(str) + m[i]);
            } 
            i++;
        }
        String ans = sb.toString();
        return trim(ans);
    }
    
    private String helper(int num) {
        StringBuilder sb = new StringBuilder();
        int hundred = num / 100;
        if (hundred > 0) {
            sb.append(digit[hundred - 1]);
            sb.append(" Hundred ");
        }
        int lastTwo = num % 100;
        int ten = (num - hundred * 100) / 10;
        int one = num % 10;
        if (ten > 1) {
            sb.append(second[ten - 2]);
        }
        else if (ten == 1) {
            sb.append(sp[lastTwo - 10]);
        }
        if (ten != 1 && one > 0) {
            sb.append(digit[one - 1]);
        }
        return sb.toString();
    }
    
    private String trim(String s) {
        if (s.length() == 0)    return s;
        return s.charAt(s.length() - 1) == ' ' ? s.substring(0, s.length() - 1) : s;
    }
}