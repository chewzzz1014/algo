import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);

        for(int i=0; i<nums.length-2; i++) {
            // skil duplicate elements for i
            if(i>0 && nums[i]==nums[i-1]) {
                continue;
            }

            int j = i+1;
            int k = nums.length-1;

            while(j<k) {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0) {
                    // triplet with zero sum
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    // skip duplicate elements for j
                    while(j<k && nums[j]==nums[j+1]) {
                        j++;
                    }
                    // skip duplicate elements for k
                    while(j<k && nums[k] == nums[k-1]) {
                        k--;
                    }

                    j++;
                    k--;
                } else if(sum<0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return ans;
    }
}
