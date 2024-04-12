package progSkills;

import java.util.Arrays;

public class LargestPerimeterTri {
    public int largestPerimeter(int[] nums) {
        // For a >= b >= c, a,b,c can form a triangle if a < b + c.
        Arrays.sort(nums);

        for(int i=nums.length-1; i>1; i--) {
            if(nums[i] < (nums[i-1] + nums[i-2]))
                return nums[i] + nums[i-1] + nums[i-2];
        }

        return 0;
    }
}
