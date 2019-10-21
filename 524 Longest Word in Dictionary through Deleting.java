class Solution {
    public String findLongestWord(String s, List<String> d) {
        if (s == null) return "";
        String ans = "";
        for (String t : d) {
            if (t.length() > ans.length() ||
                    t.length() == ans.length() && t.compareTo(ans) < 0) {
                if (check(s, t)) {
                   ans = t;
                }
            }  
        }
        return ans;
    }
    
    private boolean check(String s, String t) {
        int i = 0;
        for (int j = 0; j < t.length(); j++) {
            while (i < s.length() && s.charAt(i) != t.charAt(j)) {
                i++;
            }
            if (i == s.length())    return false;
            i++;
        }
        return true;
    }
}