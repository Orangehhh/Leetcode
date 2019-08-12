/*
 * @Author: Hao Liu
 * @Date: 2019-08-11 23:30:17
 * @LastEditors: Hao Liu
 * @LastEditTime: 2019-08-11 23:30:36
 * @Description: Dijkstra Algorithm
 */

class Solution {
    private final int KMAX = 101 * 100;
    public int networkDelayTime(int[][] times, int N, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        List<Set<int[]>> g = new ArrayList<>();
        boolean[] visited = new boolean[N + 1];
        int[] dist = new int[N + 1];
        
        buildGraph(g, times, N);
        
        for (int i = 0; i <= N; i++) {
            dist[i] = KMAX;
        }
        dist[K] = 0;
        
        pq.offer(new int[] {K, 0});
        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            if (visited[p[0]])  continue;
            visited[p[0]] = true;
            for (int[] nei : g.get(p[0])) {
                pq.remove(new int[] {nei[0], dist[nei[0]]});
                if (dist[nei[0]] > p[1] + nei[1]) {
                    dist[nei[0]] = p[1] + nei[1];
                }
                pq.offer(new int[] {nei[0], dist[nei[0]]});
            }
        }
        int ans = 0;
        for (int i = 1; i <= N; i++) {
            ans = Math.max(ans, dist[i]);
        }
        return ans == KMAX ? -1 : ans;
    }
    
    private void buildGraph(List<Set<int[]>> g, int[][] times, int N) {
        for (int i = 0; i <= N; i++) {
            g.add(new HashSet<>());
        }
        for (int[] time : times) {
            g.get(time[0]).add(new int[] {time[1], time[2]});
        }
    }
}