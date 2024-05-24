package topInterview150;

public class BestTimeBuySellStock3 {
    public int maxProfit(int[] prices) {
        // minimize cost and maximise profit
        int t1Cost = Integer.MAX_VALUE;
        int t2Cost = Integer.MAX_VALUE;
        int t1Profit = 0;
        int t2Profit = 0;

        for(int price : prices){
            // max profit if only one transaction is allowed
            t1Cost = Math.min(t1Cost, price);
            t1Profit = Math.max(t1Profit, price - t1Cost);

            // reinvest gained profit in second transaction
            t2Cost = Math.min(t2Cost, price - t1Profit);
            t2Profit = Math.max(t2Profit, price - t2Cost);
        }

        return t2Profit;
    }
}
