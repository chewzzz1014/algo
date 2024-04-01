public class BestTimeBuyAndSell {
    public int maxProfit(int[] prices) {
        // Kadane's Alogrithm: find max subarray sum in an array
        int buy = prices[0];
        int profit = 0;

        for(int i=1; i<prices.length; i++) {
            if(prices[i] < buy) {
                buy = prices[i];
            } else if (prices[i]-buy > profit) {
                profit = prices[i] - buy;
            }
        }
        return profit;
    }
}
