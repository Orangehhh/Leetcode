/*
 * @Author: Hao Liu
 * @Date: 2019-08-27 22:00:12
 * @LastEditors: Hao Liu
 * @LastEditTime: 2019-08-27 22:00:38
 * @Description: HashMap
 */

 class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();
        int m = s.length();
        for (int i = 0; i < m; i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if (map1.containsKey(sc) && map1.get(sc) != tc) {
                return false;
            }
            if (map2.containsKey(tc) && map2.get(tc) != sc) {
                return false;
            }
            map1.put(sc, tc);
            map2.put(tc, sc);
        }
        return true;
    }
}
