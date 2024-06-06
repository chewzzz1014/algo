package leetcode75;

public class MaxNumKSumPairs {
    
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        int op = 0;
        for(int n : nums) {
            // if pair found
            if(map.getOrDefault(n, 0) > 0 && map.getOrDefault(k-n, 0) > 0) {
                // skip if it's same element but its occurence < 2
                if(n == k-n && map.get(n)<2) continue;

                map.put(n, map.get(n)-1);
                map.put(k-n, map.get(k-n)-1);
                op++;
            }
        }
        return op;
    }
}
