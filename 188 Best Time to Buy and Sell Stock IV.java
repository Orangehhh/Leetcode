class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length < 2 || k < 1) {
            return 0;
        }
        if (k > prices.length / 2) {
            int ans = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1]) {
                    ans += prices[i] - prices[i - 1];
                }
            }
            return ans;
        }
        int[] buy = new int[k + 1];
        int[] sell = new int[k + 1];
        Arrays.fill(buy, Integer.MIN_VALUE);
        for (int i = 0; i < prices.length; i++) {
            for (int j = 1; j <= k; j++) {
                sell[j] = Math.max(sell[j], prices[i] + buy[j]);
                if (j == 1) {
                    buy[j] = Math.max(buy[j], -prices[i]);
                }
                else {
                    buy[j] = Math.max(buy[j], sell[j - 1] - prices[i]);
                } 
            }
        }
        return sell[k];
    }
}