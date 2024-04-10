package progSkills;

public class SignOfProduct {
    public int arraySign(int[] nums) {
        // when the number of -ve element is odd, the product will always be -ve
        boolean negCount = true;

        for(int n: nums) {
            if(n == 0) return 0;
            negCount = (n<0) ? !negCount : negCount;
        }

        return negCount ? 1 : -1;
    }
}
