/*
 * @Author: Hao Liu
 * @Date: 2019-08-14 11:43:17
 * @LastEditors: Hao Liu
 * @LastEditTime: 2019-08-14 11:43:21
 * @Description: Graph, BFS
 */

class Solution {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        if (S == T) {
            return 0;
        }
        Map<Integer, List<Integer>> g = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int stop : routes[i]) {
                if (!g.containsKey(stop)) {
                    g.put(stop, new ArrayList<>());
                }
                g.get(stop).add(i);
            }
        }
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[routes.length];
        q.offer(S);
        int buses = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            buses++;
            for (int i = 0; i < size; i++) {
                int p = q.poll();
                for (int nei : g.get(p)) {
                    if (visited[nei])   continue;
                    visited[nei] = true;
                    for (int st : routes[nei]) {
                        if (st == T)    return buses;
                        q.offer(st);
                    }
                }
            }
        }
        return -1;
    }
}