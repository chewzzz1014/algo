package leetcode75;

public class HighestAltitude {
    public int largestAltitude(int[] gain) {
        int[] altitute = new int[gain.length+1];
        int maxA = 0;

        for(int i=0; i<gain.length; i++) {
            altitute[i+1] = altitute[i] + gain[i];
            maxA = Math.max(maxA, altitute[i+1]);
        }
        return maxA;
    }
}
