class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        int[] startTime = new int[n];
        int[] endTime = new int[n];
        for (int i = 0; i < n; i++) {
            startTime[i] = intervals[i][0];
            endTime[i] = intervals[i][1];
        }
        Arrays.sort(startTime);
        Arrays.sort(endTime);
        int i = 0;
        int j = 0;
        int ans = 0;
        while (i < n) {
            if (startTime[i] < endTime[j]) {
                ans++;
            }
            else {
                j++;
            }
            i++;
        }
        return ans;
    }
}