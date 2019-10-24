class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> g = buildGraph(numCourses, prerequisites);
        List<Integer> ans = new ArrayList<>();
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 2)    continue;
            if (!dfs(i, g, visited, ans)) {
                return new int[0];
            }
        }
        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            res[i] = ans.get(i);
        }
        return res;
    }
    
    private boolean dfs(int i, List<List<Integer>> g, int[] visited, List<Integer> ans) {
        if (visited[i] == 2)    return true;
        if (visited[i] == 1)    return false;
        visited[i] = 1;
        for (int pi : g.get(i)) {
            if (!dfs(pi, g, visited, ans)) {
                return false;
            }
        }
        visited[i] = 2;
        ans.add(i);
        return true;
    }
    
    private List<List<Integer>> buildGraph(int n, int[][] prerequisites) {
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }
        for (int[] p : prerequisites) {
            g.get(p[0]).add(p[1]);
        }
        return g;
    }
}