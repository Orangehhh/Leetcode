/*
 * @Author: Hao Liu
 * @Date: 2019-08-09 16:23:05
 * @LastEditors: Hao Liu
 * @LastEditTime: 2019-08-09 16:23:58
 * @Description: Graph, single src shortest path, DFS, sub-optimal
 */

class Solution {
    class Pair {
        int v;
        int price;
        Pair(int v, int price) {
            this.v = v;
            this.price = price;
        }
    }
    
    private int ans;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, Set<Pair>> g = new HashMap<>();
        buildGraph(g, flights);
        int[] visited = new int[n];
        ans = Integer.MAX_VALUE;
        dfs(src, dst, K, 0, g, visited);   
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    
    private void buildGraph(Map<Integer, Set<Pair>> g, int[][] flights) {
        for (int[] flight : flights) {
            int start = flight[0];
            int end = flight[1];
            int price = flight[2];
            if (!g.containsKey(start)) {
                g.put(start, new HashSet<>());
            }
            g.get(start).add(new Pair(end, price));
        }
    }
    
    private void dfs(int src, int dst, int K, int cost, Map<Integer, Set<Pair>> g,
                   int[] visited) {
        if (src == dst) {
            ans = Math.min(ans, cost);
            return;
        }
        if (K < 0) {
            return;
        }
        visited[src] = 1;
        if (!g.containsKey(src)) {
            return;
        }
        for (Pair p : g.get(src)) {
            if (visited[p.v] != 0)  continue;
            if (p.price + cost > ans) continue;
            dfs(p.v, dst, K - 1, cost + p.price, g, visited);
        }
        visited[src] = 0;
    }
}