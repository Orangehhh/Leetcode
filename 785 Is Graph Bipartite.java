/*
 * @Author: Hao Liu
 * @Date: 2019-08-08 23:21:32
 * @LastEditors: Hao Liu
 * @LastEditTime: 2019-08-08 23:21:56
 * @Description: Graph, DFS 
 */

class Solution {
    public boolean isBipartite(int[][] graph) {
        if (graph == null || graph.length == 0) {
            return true;
        }
        int n = graph.length;
        int[] color = new int[n];
        for (int i = 0; i < n; i++) {
            if (color[i] != 0)   continue;
            if (!dfs(i, graph, color, 1)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean dfs(int start, int[][] graph, int[] color, int colorIdx) {
        color[start] = colorIdx;
        for (int neighbors : graph[start]) {
            if (color[neighbors] == 0) {
                if (!dfs(neighbors, graph, color, 3 - colorIdx)) {
                    return false;
                }
            }
            else if (color[neighbors] == colorIdx) {
                return false;
            }
        }
        return true;
    }
}