class Solution {
    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int n = prices.length;
        int[] buy = new int[n + 1];
        int[] sell = new int[n + 1];
        Arrays.fill(buy, -50000);
        for (int i = 1; i <= n; i++) {
            sell[i] = Math.max(sell[i - 1], prices[i - 1] + buy[i - 1] - fee);
            buy[i] = Math.max(buy[i - 1], sell[i - 1] - prices[i - 1]);
        }
        return sell[n];
    }
}