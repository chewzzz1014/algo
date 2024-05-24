package topInterview150;

public class BestTimeBuySellStock4 {
    
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;

        // if k is large enough to perform a transaction on every price changes
        // it's more profitable to buy on every low price and sell on every high price
        if(k >= len/2) return helper(prices);

        // store max profit at each transaction and each day
        // row: num of transaction
        // column: days
        int[][] dp = new int[k+1][prices.length];

        for(int i = 1; i<=k; i++) {
            for(int j = 1; j<prices.length; j++) {
                // calc max profit that can be achieved by:
                // complete prev transaction on that day
                // buy on that day and sell on that day
                int max = 0;
                for(int m = 0; m<j; m++) {
                    max = Math.max(max, dp[i-1][m] - prices[m] + prices[j]);
                }
                // get max between prev transaction and prev day
                dp[i][j] = Math.max(dp[i][j-1], max);
            }
        }
        return dp[k][prices.length-1];
    }

    // calc max profit: buy on every low price, sell on every high price
    private int helper(int[] prices) {
        int result = 0;
        for(int i = 1; i<prices.length; i++) {
            if(prices[i] > prices[i-1]) {
                result += prices[i] - prices[i-1];
            }
        }
        return result;
    }
}
