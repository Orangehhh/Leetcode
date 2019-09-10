class Solution {
    public String decodeString(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        Stack<Integer> countStack = new Stack<>();
        Stack<String> resStack = new Stack<>();
        int idx = 0;
        String res = "";
        int count = 0;
        while (idx < s.length()) {
            char ch = s.charAt(idx);
            if (ch >= '0' && ch <= '9') {
                count = count * 10 + ch - '0';
            }
            if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                res += ch;
            }
            else if (ch == '[') {
                countStack.push(count);
                count = 0;
                resStack.push(res);
                res = "";
            }
            else if (ch == ']') {
                StringBuilder tmp = new StringBuilder();
                tmp.append(resStack.pop());
                int repeatTime = countStack.pop();
                while (repeatTime > 0) {
                    tmp.append(res);
                    repeatTime--;
                }
                res = tmp.toString();
            }
            idx++;
        }
        return res;
    }
}