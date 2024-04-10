public class TwoSum2 {
    public int[] twoSum(int[] numbers, int target) {
        int i=0, j=numbers.length-1;

        while(numbers[i]+numbers[j] != target) {
            if(numbers[i]+numbers[j] > target) j--;
            else i++;
        }
        return new int[]{i+1, j+1};
    }
}
