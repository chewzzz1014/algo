package leetcode75;

public class BestTimeSellBuyTransactionFee {
    
    public int maxProfit(int[] prices, int fee) {
        if(prices.length <= 1) return 0;

        int days = prices.length;
        int buy[] = new int[days];
        int sell[] = new int[days];

        // when buy, pay fee. when sell, earn fee
        // start with either buy/sell
        buy[0] = -prices[0]-fee; // buy

        for(int i=1; i<days; i++) {
            // either buy from sell at days[i-1] or do nothing
            buy[i] = Math.max(buy[i-1], sell[i-1] - prices[i] - fee);
            // either sell from buy at days[i-1] or do nothing
            sell[i] = Math.max(sell[i-1], buy[i-1] + prices[i]);
        }
        return sell[days-1];
    }
}
