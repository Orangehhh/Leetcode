/*
 *   Copyright (c) 2019 Hao Liu
 *   All rights reserved.
 */

class Solution {
    public int largestComponentSize(int[] A) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        buildGraph(A, graph);
        Set<Integer> visited = new HashSet<>();
        int ans = 0;
        for (int num : A) {
            ans = Math.max(ans, dfs(num, graph, visited));
        }
        return ans;
    }
    
    private int dfs(int num, Map<Integer, Set<Integer>> graph, Set<Integer> visited) {
        if (visited.contains(num)) {
            return 0;
        }
        visited.add(num);
        int count = 1;
        for (int next : graph.get(num)) {
            count += dfs(next, graph, visited);
        }
        return count;
    }
    
    private void buildGraph(int[] A, Map<Integer, Set<Integer>> graph) {
        for (int num : A) {
            graph.put(num, new HashSet<>());
        }
        int n = A.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (getCommonFactor(A[i], A[j]) > 1) {
                    graph.get(A[i]).add(A[j]);
                    graph.get(A[j]).add(A[i]);
                }
            }
        }
    }
    
    private int getCommonFactor(int a, int b) {
        int ub = Math.min(a, b);
        if (b % a == 0 || a % b == 0) {
            return ub;
        }
        for (int i = ub; i >= 1; i--) {
            if (a % i == 0 && b % i == 0) {
                return i;
            }
        }
        return 1;
        
    }
}