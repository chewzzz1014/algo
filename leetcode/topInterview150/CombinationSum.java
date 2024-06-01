package topInterview150;

import java.util.*;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        helper(candidates, result, target, new ArrayList<Integer>(), 0);
        return result;
    }

    private void helper(int[] nums, List<List<Integer>> result, int target, List<Integer> temp, int start) {
        if(target < 0) return;
        if(target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int i = start; i<nums.length; i++) {
            temp.add(nums[i]);
            helper(nums, result, target - nums[i], temp, i);
            temp.remove(temp.size() - 1);
        }
    }
}
