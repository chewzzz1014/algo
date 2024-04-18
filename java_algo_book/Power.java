public class Power {
    

    public static double power1(double x, int n) {
        if(n == 0)
            return 1;
        else
            return x * power1(x, n-1);
    }

    public static double power2(double x, int n) {
        if(n == 0) return 1;

        double partial = power2(x, n/2);
        double result  = partial * partial;

        if(n % 2 != 0) {
            result *= x;
        }
        return result;
    }
}
