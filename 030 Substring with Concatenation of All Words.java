class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        if (s == null || words == null || words.length == 0) {
            return new ArrayList<>();
        }
        List<Integer> ans = new ArrayList<>();
        int n = words.length;
        int l = words[0].length();
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for (int i = 0; i <= s.length() - n * l; i++) {
            check(ans, s, i, i, map, l, n);
        }
        return ans;
    }
    
    private void check(List<Integer> ans, String s, int start, int cur, Map<String, Integer> map, int l, int count) {
        if (count == 0) {
            ans.add(start);
            return;
        }
        if (cur + l > s.length()) {
            return;
        }
        String str = s.substring(cur, cur + l);
        if (!map.containsKey(str) || map.get(str) == 0) {
            return;
        }
        int cnt = map.get(str);
        map.put(str, cnt - 1);
        check(ans, s, start, cur + l, map, l, count - 1);
        map.put(str, cnt);
    }
}