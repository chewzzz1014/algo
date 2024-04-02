public class BestTimeBuyAndSell2 {
    public int maxProfit(int[] prices) {
        int max = 0;
        int start = prices[0];
        int len = prices.length;

        for(int i=1; i<len; i++) {
            if (prices[i]>start) max += prices[i] - start;
            start = prices[i];
        }
        return max;
    }
}
