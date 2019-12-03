class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer>[] g = new ArrayList[n];
        buildGraph(g, connections);
        int[] rank = new int[n];
        int[] low = new int[n];
        Arrays.fill(rank, -2);
        dfs(ans, rank, low, g, 0, 0);
        return ans;
    }
    
    private void dfs(List<List<Integer>> ans, int[] rank, int[] low,
                    List<Integer>[] g, int i, int depth) {
        int n = g.length;
        rank[i] = depth;
        low[i] = depth;
        for (int nei : g[i]) {
            if (rank[nei] == depth - 1) continue;
            if (rank[nei] == -2) {
                dfs(ans, rank, low, g, nei, depth + 1);
                low[i] = Math.min(low[i], low[nei]);
                if (low[nei] > rank[i]) {
                    ans.add(Arrays.asList(new Integer[] {i, nei}));
                }
            }
            else {
                low[i] = Math.min(low[i], low[nei]);
            }
        }
    }
    
    private void buildGraph(List<Integer>[] g, List<List<Integer>> conn) {
        int n = g.length;
        for (List<Integer> c : conn) {
            int src = c.get(0);
            int dst = c.get(1);
            if (g[src] == null) g[src] = new ArrayList<>();
            if (g[dst] == null) g[dst] = new ArrayList<>();
            g[src].add(dst);
            g[dst].add(src);
        }
    }
}