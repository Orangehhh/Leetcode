class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s1.length() == 0) {
            return true;
        }
        if (s1.length() > s2.length()) return false;
        int[] count = new int[26];
        for (char ch : s1.toCharArray()) {
            count[ch - 'a']++;
        }
        int i = 0;
        int j = 0;
        int[] tmp = new int[26];
        while (i <= s2.length() - s1.length() && j < i + s1.length()) {
            char ch = s2.charAt(j);
            tmp[ch - 'a']++;
            while (i <= j && tmp[ch - 'a'] > count[ch - 'a']) {
                tmp[s2.charAt(i++) - 'a']--;
            }
            if (j - i + 1 == s1.length()) {
                return true;
            }
            j++;  
        }
        return false;
    }
}