public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left=0, right=height.length-1;
        int maxArea = 0;

        while(left<right) {
            int w = right-left;
            int h = Math.min(height[left], height[right]);
            int area = w * h;
            maxArea = Math.max(maxArea, area);
            if (height[left]<height[right]) left++;
            else if(height[right]<height[left]) right--;
            else {
                left++;
                right--;
            }
        }
        return maxArea;
    }
}
