package topInterview150;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if(amount < 0) return 0;

        return helper(coins, amount, new int[amount]);
    }

    private int helper(int[] coins, int remain, int[] count) {
        if(remain < 0) return -1; // not valid
        if(remain == 0) return 0; // completed

        if(count[remain-1] != 0) return count[remain-1];

        int min = Integer.MAX_VALUE;
        for(int coin : coins) {
            int result = helper(coins, remain-coin, count);
            if(result >=0 && result < min)
                min = result + 1;
        }

        count[remain - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[remain - 1];
    }
}
