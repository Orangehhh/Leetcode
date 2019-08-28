/*
 * @Author: Hao Liu
 * @Date: 2019-08-27 20:07:53
 * @LastEditors: Hao Liu
 * @LastEditTime: 2019-08-27 20:08:08
 * @Description: Interval
 */

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> l = new ArrayList<>();
        List<int[]> r = new ArrayList<>();
        int start = newInterval[0];
        int end = newInterval[1];
        for (int[] interval : intervals) {
            if (interval[1] < start) {
                l.add(interval);
            }
            else if (interval[0] > end) {
                r.add(interval);
            }
            else {
                start = Math.min(start, interval[0]);
                end = Math.max(end, interval[1]);
            }
        }
        l.add(new int[] {start, end});
        l.addAll(r);
        return l.toArray(new int[l.size()][2]);
    }
}