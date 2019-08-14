/*
 * @Author: Hao Liu
 * @Date: 2019-08-14 00:08:59
 * @LastEditors: Hao Liu
 * @LastEditTime: 2019-08-14 00:09:14
 * @Description: BFS
 */

class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        int kAns = (1 << n) - 1;
        int[][] visited = new int[n][1 << n];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) { 
            q.offer(new int[] {i, 1 << i});
        }
        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] p = q.poll();
                int curNode = p[0];
                int curState = p[1];
                if (visited[curNode][curState] == 1) continue;
                visited[curNode][curState] = 1;
                if (curState == kAns)   return steps;
                for (int nei : graph[curNode]) {
                    q.offer(new int[] {nei, curState | (1 << nei)});
                }
            }
            steps++;
        }
        return -1;
    }
}