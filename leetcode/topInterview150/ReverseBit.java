package topInterview150;

public class ReverseBit {
    
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        /*
            Steps:
            for each iteration (0-31):
                1. shift result to left by 1 (<<)
                2. find last digit of n (n&1). if last digit of n is 1, add 1 to result
                3. update n by shift to right by 1 (>>)
        */

        if(n == 0) return 0;

        int result = 0;
        for(int i=0; i<32; i++) {
            result <<= 1;
            if((n&1) == 1) result++;
            n >>= 1;
        }
        return result;
    }
}
