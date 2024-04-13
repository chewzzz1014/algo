package topInterview150;

import java.util.LinkedList;
import java.util.List;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new LinkedList<>();

        if(nums.length == 1) {
            result.add(nums[0] + "");
            return result;
        }

        for(int i=0; i<nums.length; i++) {
            int a = nums[i];
            while(i+1<nums.length && (nums[i+1]-nums[i]) == 1) {
                i++;
            }
            if (a != nums[i]) {
                result.add(a + "->" + nums[i]);
            } else {
                result.add(a + "");
            }
        }
        return result;
    }
}
