class Solution {
    public int maxProfit(int[] prices) {
        int prevMin = Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;
        for (int price : prices) {
            int profit = price - prevMin;
            maxProfit = Math.max(maxProfit, profit);
            prevMin = Math.min(prevMin, price);
        }
        return maxProfit < 0 ? 0 : maxProfit;
    }
}