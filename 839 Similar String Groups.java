/*
 *   Copyright (c) 2019 Hao Liu
 *   All rights reserved.
 */

class Solution {
    public int numSimilarGroups(String[] A) {
        Map<String, Set<String>> graph = new HashMap<>();
        buildGraph(A, graph);
        Set<String> visited = new HashSet<>();
        int ans = 0;
        for (String s : A) {
            if (visited.contains(s))    continue;
            ans++;
            dfs(s, visited, graph);
        }
        return ans;
    }
    
    private void dfs(String s, Set<String> visited, Map<String, Set<String>> graph) {
        if (visited.contains(s))    return;
        visited.add(s);
        for (String next : graph.get(s)) {
            dfs(next, visited, graph);
        }
    }

    private void buildGraph(String[] A, Map<String, Set<String>> graph) {
        int n = A.length;
        for (int i = 0; i < n; i++) {
            graph.put(A[i], new HashSet<>());
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                String first = A[i];
                String second = A[j];
                if (isSimilar(first, second)) {
                    graph.get(first).add(second);
                    graph.get(second).add(first);
                }
            }
        }
    }
    
    private boolean isSimilar(String a, String b) {
        int n = a.length();
        int diff = 0;
        for (int i = 0; i < n; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
                if (diff > 2) {
                    return false;
                }
            }
        }
        return true;
    }
}