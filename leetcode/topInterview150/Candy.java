import java.util.Arrays;

public class Candy {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candy = new int[n];
        Arrays.fill(candy, 1);

        // check from left: right child with higher rating get more candies
        for(int i=1; i<n; i++) {
            if (ratings[i]>ratings[i-1])
                candy[i] = candy[i-1] + 1;
        }

        // check for right: left child with higher rating get more candies
        for(int i=n-1; i>0; i--) {
            if(ratings[i-1]>ratings[i])
                candy[i-1] = Math.max(candy[i]+1, candy[i-1]);
        }

        int totalCandy = 0;
        for(int c: candy) {
            totalCandy += c;
        }

        return totalCandy;

    }
}
