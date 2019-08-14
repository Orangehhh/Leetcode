/*
 * @Author: Hao Liu
 * @Date: 2019-08-13 23:27:42
 * @LastEditors: Hao Liu
 * @LastEditTime: 2019-08-13 23:28:09
 * @Description: Dijkstra Algorithm
 */

class Solution {
    public int reachableNodes(int[][] edges, int M, int N) {
        
        List<List<int[]>> g = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            g.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            g.get(edge[0]).add(new int[] {edge[1], edge[2]});
            g.get(edge[1]).add(new int[] {edge[0], edge[2]});
        }
        
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> (b[1] - a[1]));
        Map<Integer, Integer> map = new HashMap<>();
        pq.offer(new int[] {0, M});
        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            if (map.containsKey(p[0])) continue;
            map.put(p[0], p[1]);
            for (int[] nei : g.get(p[0])) {
                if (map.containsKey(nei[0]) || p[1] - nei[1] - 1 < 0)   continue;
                pq.offer(new int[] {nei[0], p[1] - nei[1] - 1});
            }
        }
        
        int ans = map.size();
        for (int[] edge : edges) {
            int u = map.containsKey(edge[0]) ? map.get(edge[0]) : 0;
            int v = map.containsKey(edge[1]) ? map.get(edge[1]) : 0;
            ans += Math.min(edge[2], u + v);
        }
        return ans;
    }
}