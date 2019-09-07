class Solution {
    public String longestPalindrome(String s) {
        if (s == null) {
            return null;
        }
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            String tmp1 = longestPalindrome(s, i, i);
            String tmp2 = longestPalindrome(s, i, i + 1);
            if (tmp1.length() > ans.length()) {
                ans = tmp1;
            }
            if (tmp2.length() > ans.length()) {
                ans = tmp2;
            } 
        }
        return ans;
    }
    
    private String longestPalindrome(String s, int l, int r) {
        while (l >= 0 && r < s.length()) {
            if (s.charAt(l) != s.charAt(r)) {
                break;
            }
            l--;
            r++;
        }
        return s.substring(l + 1, r);
    }
}