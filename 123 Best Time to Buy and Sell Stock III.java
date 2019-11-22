class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int oneBuy = Integer.MIN_VALUE;
        int oneSell = 0;
        int twoBuy = Integer.MIN_VALUE;
        int twoSell = 0;
        for (int i = 0; i < prices.length; i++) {
            twoSell = Math.max(twoSell, prices[i] + twoBuy);
            twoBuy = Math.max(twoBuy, oneSell - prices[i]);
            oneSell = Math.max(oneSell, prices[i] + oneBuy);
            oneBuy = Math.max(oneBuy, -prices[i]);
        }
        return Math.max(oneSell, twoSell);
    }
}