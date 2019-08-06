/*
 *   Copyright (c) 2019 Hao Liu
 *   All rights reserved.
 */

class Solution {
        class Pair {
        String parent;
        double value;
        Pair(String parent, double value) {
            this.parent = parent;
            this.value = value;
        }
    }
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
        List<Double> res = new ArrayList<>();
        Map<String, Pair> map = new HashMap<>();
        
        for (int i = 0; i < equations.size(); ++i) {
            List<String> eq = equations.get(i);
            String A = eq.get(0);
            String B = eq.get(1);
            if (!map.containsKey(A) && !map.containsKey(B)) {
                map.put(A, new Pair(B, values[i]));
                map.put(B, new Pair(B, 1.0));
            }
            else if (!map.containsKey(A)) {
                map.put(A, new Pair(B, values[i]));
            }
            else if (!map.containsKey(B)) {
                map.put(B, new Pair(A, 1.0 / values[i]));
            }
            else {
                Pair rA = find(A, map);
                Pair rB = find(B, map);
                if (!rA.parent.equals(rB.parent)) {
                    rA.parent = rB.parent;
                }
                rA.value = values[i] * rB.value / rA.value;
            }
        }
        
        for (int i = 0; i < queries.size(); ++i) {
            List<String> query = queries.get(i);
            String A = query.get(0);
            String B = query.get(1);
            if (!map.containsKey(A) || !map.containsKey(B)) {
                res.add(-1.0);
                continue;
            }
            Pair rA = find(A, map);
            Pair rB = find(B, map);
            if (!rA.parent.equals(rB.parent)) {
                res.add(-1.0);
            }
            else {
                res.add(map.get(A).value / map.get(B).value);
            }
        }
        
        double[] ans = new double[res.size()];
        for (int i = 0; i < res.size(); ++i) {
            ans[i] = res.get(i);
        }
        return ans;
    }
    
    public Pair find(String A, Map<String, Pair> map) {
        Pair pA = map.get(A);
        if (A.equals(pA.parent)) {
            return pA;
        }
        Pair rA = find(pA.parent, map);
        pA.parent = rA.parent;
        pA.value = pA.value * rA.value;
        return pA;
    }
}