package topInterview150;

public class NumberOf1Bits {
    
    public int hammingWeight(int n) {
        int ones = 0;

        while(n != 0) {
            ones += (n&1);
            n >>>= 1; // unsigned shift
        }

        return ones;
    }
}
