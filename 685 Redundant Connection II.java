/*
 * @Author: Hao Liu
 * @Date: 2019-08-09 14:57:47
 * @LastEditors: Hao Liu
 * @LastEditTime: 2019-08-09 14:58:25
 * @Description: Direct Graph, Union Find, Cycle
 */

class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] root = new int[n + 1];
        int[] parent = new int[n + 1];
        int[] ans1 = new int[2];
        int[] ans2 = new int[2];
        for (int i = 0; i <= n; i++) {
            root[i] = i;
        }
        
        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];
            if (parent[end] > 0) {
                ans1 = new int[]{parent[end], end};
                ans2 = new int[]{start, end};
                edge[0] = -1;
                edge[1] = -1;
            }
            parent[end] = start;
        }
        
        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];
            if (start < 0 || end < 0)  continue;
            int rStart = find(start, root);
            int rEnd = find(end, root);
            if (rStart != rEnd) {
                root[rEnd] = rStart; 
            }
            else {
                return ans1[0] == 0 ? edge : ans1;
            }
        }
        return ans2;
    }
    
    private int find(int a, int[] root) {
        if (root[a] == a) {
            return a;
        }
        int pA = find(root[a], root);
        root[a] = pA;
        return pA;
    }
}