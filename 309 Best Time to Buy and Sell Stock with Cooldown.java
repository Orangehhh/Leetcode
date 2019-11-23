class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int n = prices.length;
        int bought = Integer.MIN_VALUE;
        int sold = 0;
        int hold = 0;
        for (int i = 1; i <= n; i++) {
            int tmp = hold;
            hold = Math.max(hold, sold);
            sold = prices[i - 1] + bought;
            bought = Math.max(bought, tmp - prices[i - 1]);
        }
        return Math.max(sold, hold);
    }
}