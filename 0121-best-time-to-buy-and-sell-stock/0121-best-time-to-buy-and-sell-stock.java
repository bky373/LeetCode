class Solution {
    public int maxProfit(int[] prices) {
        int hold = prices[0];
        int profit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < hold) {
                hold = prices[i];
            }

            if (prices[i] - hold > profit) {
                profit = prices[i] - hold;
            }
        }
        return profit;
    }
}