class Solution {
    private final int kMod = 1000000007;
    public int uniqueLetterString(String S) {
        if (S == null || S.length() == 0) {
            return 0;
        }
        Map<Character, List<Integer>> map = new HashMap<>();
        int n = S.length();
        for (int i = 0; i < n; i++) {
            char ch = S.charAt(i);
            if (!map.containsKey(ch)) {
                map.put(ch, new ArrayList<>());
            }
            map.get(ch).add(i);
        }
        int ans = 0;
        for (List<Integer> pos : map.values()) {
            for (int i = 0; i < pos.size(); i++) {
                int prev = i > 0 ? pos.get(i - 1) : -1;
                int next = i < pos.size() - 1 ? pos.get(i + 1) : S.length();
                ans = (ans + (pos.get(i) - prev) * (next - pos.get(i))) % kMod;
            }
        }
        return ans;
    }
}