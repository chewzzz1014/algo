package topInterview150;

import java.util.*;

public class Combinations {
    
    public List<List<Integer>> combine(int n, int k) {
        int[] nums = new int[n];
        for(int i=0; i<n; i++) {
            nums[i] = i + 1;
        }

        List<List<Integer>> result = new ArrayList<>();
        helper(result, nums, new ArrayList<>(), 0, k);
        return result;
    }

    public void helper(List<List<Integer>> result, int[] nums, List<Integer> temp, int index, int count) {
        // desired number of elements is selected
        // add current combination
        if(count == 0) { 
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int i=index; i<nums.length; i++) {
            temp.add(nums[i]);
            helper(result, nums, temp, i+1, count-1);
            temp.remove(temp.size() - 1);
        }
    }
}
