/*
 * @Author: Hao Liu
 * @Date: 2019-08-27 16:39:19
 * @LastEditors: Hao Liu
 * @LastEditTime: 2019-08-27 16:39:36
 * @Description: Interval
 */

 class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1 || intervals[0].length < 2) {
            return intervals;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] i1, int[] i2) {
                return i1[0] - i2[0];
            }
        });
        List<int[]> ans = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int first = intervals[i][0];
            int second = intervals[i][1];
            if (first > end) {
                ans.add(new int[] {start, end});
                start = first;
                end = second;
            }
            end = Math.max(end, second);
        }
        ans.add(new int[] {start, end});
        return ans.toArray(new int[ans.size()][2]);
    }
}
