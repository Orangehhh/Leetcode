class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int[][] arr = new int[difficulty.length][2];
        for (int i = 0; i < difficulty.length; i++) {
            arr[i][0] = difficulty[i];
            arr[i][1] = profit[i];
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] == b[0] ? a[1] - b[1] : a[0] - b[0];
            }
        });
        int p = 0;
        for (int i = 0; i < arr.length; i++) {
            p = Math.max(p, arr[i][1]);
            arr[i][1] = p;
        }
        int ans = 0;
        for (int w : worker) {
            ans += getProfit(arr, w);
        }
        return ans;
    }
    
    private int getProfit(int[][] arr, int w) {
        int l = 0;
        int r = arr.length - 1;
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid][0] > w) {
                r = mid;
            }
            else {
                l = mid;
            }
        }
        if (arr[r][0] <= w) {
            return arr[r][1];
        }
        if (arr[l][0] <= w) {
            return arr[l][1];
        }
        return 0;
    }
}