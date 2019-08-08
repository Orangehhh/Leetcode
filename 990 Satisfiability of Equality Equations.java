/*
 * @Author: Hao Liu
 * @Date: 2019-08-08 16:45:38
 * @LastEditors: Hao Liu
 * @LastEditTime: 2019-08-08 16:46:34
 * @Description: Union Find, Two-pass
 */

class Solution {
    public boolean equationsPossible(String[] equations) {
        Map<Character, Character> g = new HashMap<>();
        for (String eq : equations) {
            if (eq.charAt(1) == '!')    continue;
            char first = eq.charAt(0);
            char second = eq.charAt(3);
            if (g.containsKey(first) && 
                g.containsKey(second)) {
                char rFirst = findRoot(first, g);
                char rSecond = findRoot(second, g);
                g.put(rFirst, rSecond);
            }
            else if (g.containsKey(first)) {
                g.put(second, findRoot(first, g));
            }
            else if (g.containsKey(second)) {
                g.put(first, findRoot(second, g));
            }
            else {
                g.put(first, second);
                g.put(second, second);
            }
        }
        for (String eq : equations) {
            if (eq.charAt(1) == '=')    continue;
            char first = eq.charAt(0);
            char second = eq.charAt(3);
            if (first == second) {
                return false;
            }
            if (g.containsKey(first) && g.containsKey(second)) {
                char rFirst = findRoot(first, g);
                char rSecond = findRoot(second, g);
                if (rFirst == rSecond) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private char findRoot(char a, Map<Character, Character> g) {
        if (a == g.get(a)) {
            return a;
        }
        char pA = findRoot(g.get(a), g);
        g.put(a, pA);
        return g.get(a);
    }
}