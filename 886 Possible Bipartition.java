/*
 * @Author: Hao Liu
 * @Date: 2019-08-09 10:44:23
 * @LastEditors: Hao Liu
 * @LastEditTime: 2019-08-09 10:44:37
 * @Description: Graph, DFS
 */

class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        List<Set<Integer>> g = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            g.add(new HashSet<>());
        }
        for (int[] dislike : dislikes) {
            g.get(dislike[0]).add(dislike[1]);
            g.get(dislike[1]).add(dislike[0]);
        }
        int[] color = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            if (color[i] != 0)  continue;
            if (!dfs(i, g, color, 1)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean dfs(int start, List<Set<Integer>> g, int[] color, int colorIdx) {
        color[start] = colorIdx;
        for (int neighbor : g.get(start)) {
            if (color[neighbor] == colorIdx || 
                (color[neighbor] == 0 && !dfs(neighbor, g, color, 3 - colorIdx))) {
                return false;
            }
        }
        return true;
    }
}