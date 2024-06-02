package topInterview150;

public class FactorialTrailingZeroes {
    
    public int trailingZeroes(int n) {
        // we'll get 0 when there's 2*5
        // get the number of 5 (bcs if there's 5, there must always be 2)
        if(n == 0) return 0;
        return n/5 + (trailingZeroes(n/5));
    }
}
