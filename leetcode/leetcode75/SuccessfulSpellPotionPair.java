package leetcode75;

import java.util.Arrays;

public class SuccessfulSpellPotionPair {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        int[] result = new int[n];

        Arrays.sort(potions);

        for(int i=0; i<n; i++) {
            // use binary search to find number of potions that forms successful pair w/ current spell
            // get the number of pairs by taking # potions in second half
            int currSpell = spells[i];
            int left=0, right=m-1;

            while(left <= right) {
                int mid = left + (right-left) / 2;
                long product = (long) potions[mid] * currSpell;
                if(product >= success) {
                    right = mid-1;
                } else {
                    left = mid + 1;
                }
            }
            result[i] = m - left; // # potions in second half
        }
        return result;
    }
}