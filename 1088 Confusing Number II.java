class Solution {
    
    private char[][] pairs = new char[][] 
                {{'0', '0'}, {'1', '1'}, {'6', '9'}, {'8', '8'}, {'9', '6'}};
    
    public int confusingNumberII(int N) {
        if (N <= 1) {
            return 0;
        }
        String n = Integer.toString(N);
        int total = getTotal(n);
        for (int i = 1; i <= n.length(); i++) {
            total -= dfs(n, new char[i], 0, i - 1);
        }
        return total;
    }
    
    private int getTotal(String n) {
        if (n.length() == 0) {
            return 1;
        }
        char first = n.charAt(0);
        int count = count(first) * (int) Math.pow(5, n.length() - 1);
        if (first == '0' || first == '1' || first == '6' || first == '8' || first == '9') {
            count += getTotal(n.substring(1));
        }
        return count;
    }
    
    private int dfs(String n, char[] ch, int left, int right) {
        if (left > right) {
            String s = new String(ch);
            if (s.length() == n.length() && s.compareTo(n) > 0) {
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
            if (left == right && (ch[left] == '6' || ch[left] == '9')) {
                continue;
            }
            count += dfs(n, ch, left + 1, right - 1);
        }
        return count;
    }
    
    private int count(char c) {
        int count = 0;
        for (char[] p : pairs) {
            if (p[0] < c) {
                count++;
            }
        }
        return count;
    }
}