class Solution {
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t.length() == 0) {
            return "";
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : t.toCharArray()) {
            int count = map.getOrDefault(ch, 0);
            map.put(ch, count + 1);
        }
        int numOfCharacters = map.size();
        int l = 0;
        int r = 0;
        int[] ans = {-1, 0, 0};
        Map<Character, Integer> windowCounts = new HashMap<>();
        int matchedCharacters = 0;
        while (r < s.length()) {
            char ch = s.charAt(r);
            int count = windowCounts.getOrDefault(ch, 0);
            windowCounts.put(ch, count + 1);
            if (map.containsKey(ch) && map.get(ch).intValue() == windowCounts.get(ch).intValue()) {
                matchedCharacters++;
            }
            while (l <= r && matchedCharacters == numOfCharacters) {
                ch = s.charAt(l);
                if (ans[0] == -1 || r - l + 1 < ans[0]) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }
                windowCounts.put(ch, windowCounts.get(ch) - 1);
                if (map.containsKey(ch) && map.get(ch) > windowCounts.get(ch)) {
                    matchedCharacters--;
                }
                l++;
            }
            r++;
        }
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
}