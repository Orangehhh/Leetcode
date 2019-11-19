class Solution {
    public int longestStrChain(String[] words) {
        if (words == null || words.length == 0) {
            return 0;
        }
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.length() == s2.length() ? s1.compareTo(s2) : s1.length() - s2.length();
            }
        });
        int n = words.length;
        Map<String, Integer> idxMap = new HashMap<>();
        int[] dp = new int[n + 1];
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            String word = words[i - 1];
            dp[i] = 1;
            for (int j = 0; j < word.length(); j++) {
                String cutWord = word.substring(0, j) + word.substring(j + 1);
                if (idxMap.containsKey(cutWord)) {
                    dp[i] = Math.max(dp[i], dp[idxMap.get(cutWord)] + 1);
                }
            }
            idxMap.put(word, i);
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}