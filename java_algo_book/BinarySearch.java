public class BinarySearch {
    
    public static int binarySearch(int[] data, int target, int low, int high) {
        if(low > high) return -1;

        int mid = (low + high) / 2;
        if(target == data[mid]) {
            return mid;
        } else if(target < data[mid]) {
            return binarySearch(data, target, low, mid-1);
        } else {
            return binarySearch(data, target, mid+1, high);
        }
    }
}
