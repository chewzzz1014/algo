public class JumpGame2 {
    public int jump(int[] nums) {
        int jumps = 0;
        int curEnd = 0;
        int curFarthest = 0;

        for(int i = 0; i<nums.length-1; i++) {
            curFarthest = Math.max(curFarthest, i + nums[i]);
            if (i == curEnd) {
                jumps++;
                curEnd = curFarthest;
            }
        }
        return jumps;
    }
}
