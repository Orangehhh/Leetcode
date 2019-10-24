class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 1 || prerequisites == null || prerequisites.length == 0) {
            return true;
        }
        List<List<Integer>> g = buildGraph(numCourses, prerequisites);
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 2) continue;
            if (!dfs(i, g, visited)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int i, List<List<Integer>> g, int[] visited) {
        if (visited[i] == 1)    return false;
        if (visited[i] == 2)    return true;
        visited[i] = 1;
        for (int pi : g.get(i)) {
            if (!dfs(pi, g, visited)) {
                return false;
            }
        }
        visited[i] = 2;
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