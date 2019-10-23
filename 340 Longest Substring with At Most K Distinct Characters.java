class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0 || k == 0) {
            return 0;
        }
        int ans = 0;
        int[] count = new int[256];
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            char ch = s.charAt(j);
            count[ch]++;
            if (count[ch] == 1) k--;
            while (k < 0) {
                count[s.charAt(i)]--;
                if (count[s.charAt(i)] == 0)    k++;
                i++;
            }
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }
}