class Solution {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> g = buildGraph(words);
        Map<Character, Integer> visited = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (char ch : g.keySet()) {
            if (!dfs(ch, g, visited, sb)) {
                return "";
            }
        }
        return sb.toString();
    }
    
    private boolean dfs(char ch, Map<Character, Set<Character>> g,
                       Map<Character, Integer> visited, StringBuilder sb) {
        if (visited.containsKey(ch) && visited.get(ch) == 2) return true;
        if (visited.containsKey(ch) && visited.get(ch) == 1) return false;
        visited.put(ch, 1);
        if (g.containsKey(ch)) {
            for (char pChar : g.get(ch)) {
                if (!dfs(pChar, g, visited, sb)) {
                    return false;
                }
            }
        }
        visited.put(ch, 2);
        sb.append(ch);
        return true;
    }
    
    private Map<Character, Set<Character>> buildGraph(String[] words) {
        Map<Character, Set<Character>> g = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            for (char ch : words[i].toCharArray()) {
                if (!g.containsKey(ch)) g.put(ch, new HashSet<>());
            }
        }
        for (int i = 0; i < words.length - 1; i++) {
            int j = i + 1;
            int k = 0;
            while (k < words[i].length() && k < words[j].length()) {
                char ci = words[i].charAt(k);
                char cj = words[j].charAt(k);
                if (ci != cj) {
                    g.get(cj).add(ci);
                    break;
                }
                else {
                    k++;
                }
            }
        }
        return g;
    }
}