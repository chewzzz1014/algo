public class Fibonacci {
    

    public static long fibonacciBad(int n) {
        if(n <= 1)
            return n;
        else
            return fibonacciBad(n - 2) + fibonacciBad(n - 1);
    }
}
