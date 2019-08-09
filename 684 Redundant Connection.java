/*
 * @Author: Hao Liu
 * @Date: 2019-08-09 12:23:04
 * @LastEditors: Hao Liu
 * @LastEditTime: 2019-08-09 12:23:48
 * @Description: Cycle + Union Find
 */

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }
        int[] ans = new int[2];
        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];
            int rStart = find(start, parent);
            int rEnd = find(end, parent);
            if (rStart == rEnd) {
                ans = edge;
                break;
            }
            else {
                parent[rStart] = rEnd;
            }
        }
        return ans;
    }
    
    public int find(int a, int[] parent) {
        if (parent[a] == a) {
            return a;
        }
        int pA = find(parent[a], parent);
        parent[a] = pA;
        return pA;
    }
}