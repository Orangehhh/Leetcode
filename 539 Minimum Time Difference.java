class Solution {
    public int findMinDifference(List<String> timePoints) {
        int[] arr = new int[1440];
        for (String time : timePoints) {
            String[] timeArr = time.split(":");
            int hour = Integer.parseInt(timeArr[0]);
            int minute = Integer.parseInt(timeArr[1]);
            arr[hour * 60 + minute]++;
        }
        int min = 1440;
        int max = 0;
        int prev = Integer.MIN_VALUE;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 1440; i++) {
            if (arr[i] > 1) return 0;
            if (arr[i] == 0)    continue;
            min = Math.min(min, i);
            max = Math.max(max, i);
            if (prev != Integer.MIN_VALUE) {
                ans = Math.min(ans, i - prev);
            }
            prev = i;
        }
        return Math.min(ans, 1440 - (max - min));
    }
}