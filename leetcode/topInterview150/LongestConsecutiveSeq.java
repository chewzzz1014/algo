package topInterview150;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSeq {
    public int longestConsecutive(int[] nums) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for(int n : nums) {
            if(!map.containsKey(n)) {
                int left = map.getOrDefault(n-1, 0);
                int right = map.getOrDefault(n+1, 0);
                int sum = left + right + 1;
            
                map.put(n, sum);

                result = Math.max(result, sum);

                map.put(n-left, sum);
                map.put(n+right, sum);
            } else {
                // duplicated
                continue;
            }
        }
        return result;
    }
}
