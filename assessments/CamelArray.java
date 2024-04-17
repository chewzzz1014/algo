package assessments;

public class CamelArray {
    
    public boolean isCamelArray(int[] arr) {
        int n = arr.length;
        int direction = 1;

        for(int i=1; i<n; i++) {
            if((direction>0 && arr[i-1]>arr[i]) || (direction<0 && arr[i-1]<arr[i])) 
                return false;
            direction *= -1;
        }
        return true;
    }
}
