package topInterview150;

public class Sqrt {
    
    public int mySqrt(int x) {
        // binary search
        long start = 1, end = x;

        while(start + 1 < end) {
            long mid = (start + end) / 2;
            if(mid * mid == x) {
                return (int) mid;
            } else if(mid * mid < x) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if(end*end <= x) return (int) end;
        else return (int) start;
    }
}
