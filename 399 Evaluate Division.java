/*
 * @Author: Hao Liu
 * @Date: 2019-08-05 21:32:12
 * @LastEditors: Hao Liu
 * @LastEditTime: 2019-08-08 14:37:08
 * @Description: Graph, DFS
 */


class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> map = new HashMap<>();
//      Store equations and values in a map
        for (int i = 0; i < equations.size(); ++i) {
            List<String> eq = equations.get(i);
            if (!map.containsKey(eq.get(0))) {
                map.put(eq.get(0), new HashMap<>());
            }
            if (!map.containsKey(eq.get(1))) {
                map.put(eq.get(1), new HashMap<>());
            }
            map.get(eq.get(0)).put(eq.get(1), values[i]);
            map.get(eq.get(1)).put(eq.get(0), 1.0 / values[i]);
        }
//      Calculate divisions
        List<Double> res = new ArrayList<>();
        for (List<String> query : queries) {
            res.add(dfs(query.get(0), query.get(1), map, new HashSet<>()));
        }
//      Convert arrayList to array
        double[] ans = new double[res.size()];
        for (int i = 0; i < res.size(); ++i) {
            ans[i] = res.get(i);
        }
        return ans;
    }
    
    public double dfs(String A, String B, Map<String, Map<String, Double>> map,
                     Set<String> visited) {
        if (!map.containsKey(A) || !map.containsKey(B)) {
            return -1.0;
        }
        if (A.equals(B)) {
            return 1.0;
        }
        visited.add(A);
        Map<String, Double> neighbors = map.get(A);
        for (Map.Entry<String, Double> entry : neighbors.entrySet()) {
            if (visited.contains(entry.getKey())) {
                continue;   
            }
            double d = dfs(entry.getKey(), B, map, visited);
            if (d > 0) {
                return d * map.get(A).get(entry.getKey());
            }
        }
        return -1.0;
    }
}