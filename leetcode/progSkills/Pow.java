package progSkills;

public class Pow {
    public double myPow(double x, int n) {
        // divide the work using binary representation of exponents
        if(n<0) {
            n = -n;
            x = 1 / x;
        }

        double pow = 1;

        while(n != 0) {
            // equivalent to if((n % 2) != 0) i.e. multiply only when the number is odd  
            if((n&1) != 0) {
                pow *= x;
            }

            x *= x;
            // equivalent to n = n / 2; i.e. keep dividing the number by 2
            n >>>= 1;
        }

        return pow;
    }
}
