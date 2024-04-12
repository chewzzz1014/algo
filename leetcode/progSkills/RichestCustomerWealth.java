import java.util.Arrays;

public class RichestCustomerWealth {
    public int maximumWealth(int[][] accounts) {
        return Arrays.stream(accounts)
                    .mapToInt(ele -> Arrays.stream(ele).sum())
                    .max()
                    .getAsInt();
    }
}