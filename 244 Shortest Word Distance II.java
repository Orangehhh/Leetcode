class WordDistance {
    
    private Map<String, List<Integer>> map;
    
    public WordDistance(String[] words) {
        map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (!map.containsKey(words[i])) {
                map.put(words[i], new ArrayList<>());
            }
            map.get(words[i]).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> arr1 = map.get(word1);
        List<Integer> arr2 = map.get(word2);
        int i = 0;
        int j = 0;
        int ans = Integer.MAX_VALUE;
        while (i < arr1.size() && j < arr2.size()) {
            int num1 = arr1.get(i);
            int num2 = arr2.get(j);
            ans = Math.min(ans, Math.abs(num1 - num2));
            if (num1 > num2) {
                j++;
            }
            else {
                i++;
            }
        }
        return ans;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */