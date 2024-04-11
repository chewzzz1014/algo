package progSkills;

public class MonotonicArr {
    public boolean isMonotonic(int[] nums) {
        boolean asc = true, desc = true;
        for(int i=1; i<nums.length; i++) {
            asc &= nums[i] >= nums[i-1];
            desc &= nums[i] <= nums[i-1];
        }
        return asc || desc;
    }
}
