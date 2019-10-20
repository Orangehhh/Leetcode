class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int i = 0;
        Map<Character, Integer> map = new HashMap<>();
        int count = 0;
        int ans = 0;
        for (int j = 0; j < s.length(); j++) {
            char ch = s.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            if (map.get(ch) == 1) count++;
            while (count > 2) {
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                if (map.get(s.charAt(i)) == 0)  count--;
                i++;
            }
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }
}