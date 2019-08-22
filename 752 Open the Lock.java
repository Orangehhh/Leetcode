/*
 * @Author: Hao Liu
 * @Date: 2019-08-21 22:14:09
 * @LastEditors: Hao Liu
 * @LastEditTime: 2019-08-21 22:14:27
 * @Description: One-directional BFS
 */

 class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> deadSet = new HashSet<>();
        for (String deadend : deadends) {
            deadSet.add(deadend);
        }
        Set<String> visited = new HashSet<>();
        String initStr = "0000";
        if (deadSet.contains(initStr) || deadSet.contains(target))   return -1;
        visited.add(initStr);
        Queue<String> q = new LinkedList<>();
        q.offer(initStr);
        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            steps++;
            for (int i = 0; i < size; i++) {
                String str = q.poll();
                StringBuilder sb = new StringBuilder(str);
                for (int l = 0; l < 4; l++) {
                    char ch = sb.charAt(l);
                    for (int k = -1; k <= 1; k++) {
                        if (k == 0) continue;
                        sb.setCharAt(l, (char) ((ch - '0' + k + 10) % 10 + '0'));
                        String newStr = sb.toString();
                        if (newStr.equals(target))   return steps;
                        if (visited.contains(newStr) || deadSet.contains(newStr)) {
                            continue;
                        }
                        q.offer(newStr);
                        visited.add(newStr);
                    }
                    sb.setCharAt(l, ch);
                }
            }
        }
        return -1;
    }
}
