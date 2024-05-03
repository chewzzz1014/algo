package topInterview150;

public class SingleNumber2 {
 
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;

        for(int n : nums) {
            ones = (ones ^ n) & ~twos;
            twos = (twos ^ n) & ~ones;
        }
        return ones;
    }
}