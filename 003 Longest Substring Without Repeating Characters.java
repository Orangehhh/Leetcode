class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        int j = -1;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch) && map.get(ch) > j) {
                j = map.get(ch);
            }
            map.put(ch, i);
            ans = Math.max(ans, i - j);
        }
        return ans;
    }
}