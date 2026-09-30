class Solution {
    public int maxProfit(int k, int[] prices) {

        if (prices.length == 0 || k == 0)
            return 0;
        if (k >= prices.length / 2) {
            int profit = 0;

            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1]) {
                    profit += prices[i] - prices[i - 1];
                }
            }
            return profit;
        }
        int[] buy = new int[k + 1];
        int[] sell = new int[k + 1];
        Arrays.fill(buy, Integer.MIN_VALUE);
        for (int price : prices) {
            for (int transaction = 1; transaction <= k; transaction++) {
                buy[transaction] = Math.max(buy[transaction],sell[transaction - 1] - price);
                sell[transaction] = Math.max(sell[transaction],buy[transaction] + price);
            }
        }

        return sell[k];
    }
}