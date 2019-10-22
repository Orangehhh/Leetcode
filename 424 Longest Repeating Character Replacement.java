class Solution {
    public int characterReplacement(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int i = 0;
        int[] count = new int[26];
        int ans = 0;
        int maxCount = 0;
        for (int j = 0; j < n; j++) {
            char curChar = s.charAt(j);
            count[curChar - 'A']++;
            maxCount = Math.max(maxCount, count[curChar - 'A']);
            if (j - i + 1 - maxCount > k) {
                count[s.charAt(i) - 'A']--;
                i++;
            }
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }
}