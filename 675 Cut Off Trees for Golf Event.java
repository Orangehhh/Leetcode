/*
 * @Author: Hao Liu
 * @Date: 2019-08-22 11:39:49
 * @LastEditors: Hao Liu
 * @LastEditTime: 2019-08-22 11:40:03
 * @Description: BFS
 */

class Solution {
    class Pair {
        int idx;
        int num;
        Pair(int idx, int num) {
            this.idx = idx;
            this.num = num;
        }
    }
    public int cutOffTree(List<List<Integer>> forest) {
        if (forest == null || forest.size() == 0 || forest.get(0).size() == 0) {
            return 0;
        }
        int m = forest.size();
        int n = forest.get(0).size();
        PriorityQueue<Pair> pq = new PriorityQueue<>(1, new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                return p1.num - p2.num;
            }
        });
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (forest.get(i).get(j) > 1) {
                    pq.offer(new Pair(i * n + j, forest.get(i).get(j)));
                }
            }
        }
        int ans = 0;
        int i = 0;
        int j = 0;
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int num = p.num;
            int[][] visited = new int[m][n];
            int dist = getDist(num, forest, i, j, visited);
            if (dist == -1) {
                return dist;
            }
            ans += dist;
            i = p.idx / n;
            j = p.idx % n;
        }
        return ans;
    }
    
    private int getDist(int num, List<List<Integer>> forest, int i, int j, int[][] visited) {
        int m = forest.size();
        int n = forest.get(0).size();
        Queue<Integer> q = new LinkedList<>();
        q.offer(i * n + j);
        visited[i][j] = 1;
        int dist = 0;
        if (forest.get(i).get(j) == num) {
            return dist;
        }
        int[] dirs = {-1, 0, 1, 0, -1};
        while (!q.isEmpty()) {
            dist++;
            int size = q.size();
            for (int l = 0; l < size; l++) {
                int idx = q.poll();
                int r = idx / n;
                int c = idx % n;
                for (int k = 0; k < 4; k++) {
                    int nr = r + dirs[k];
                    int nc = c + dirs[k + 1];
                    if (nr < 0 || nc < 0 || nr >= m || nc >= n ||forest.get(nr).get(nc) == 0 || visited[nr][nc] == 1)   continue;
                    if (forest.get(nr).get(nc) == num) {
                        forest.get(nr).set(nc, 1);
                        return dist;
                    }
                    q.offer(nr * n + nc);
                    visited[nr][nc] = 1;
                }
            }
        }
        return -1;
    }
}
