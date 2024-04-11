package progSkills;

import java.util.HashSet;
import java.util.Set;

public class CanMakeArithmeticProgression {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Set<Integer> seen = new HashSet<>();
        int mi = Integer.MAX_VALUE, mx = Integer.MIN_VALUE;
        int n = arr.length;

        // get min, max, seen elements
        for(int a : arr) {
            mi = Math.min(mi, a);
            mx = Math.max(mx, a);
            seen.add(a);
        }

        // get the avg diff
        int diff = mx - mi;
        if(diff % (n-1) != 0) return false;
        diff /= (n-1);

        // starting from min, is min+avg_diff in the arr?
        for(int i=0; i<n; i++) {
            if(!seen.contains(mi)) return false;
            mi += diff;
        }
        return true;
    }
}
