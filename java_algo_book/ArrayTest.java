import java.util.Arrays;
import java.util.Random;

public class ArrayTest {
    public static void main(String[] args) {
        int data[] = new int[10];
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());

        for(int i=0; i<data.length; i++) {
            data[i] = random.nextInt(100); // random number in [0, 100)
        }

        int[] copy = Arrays.copyOf(data, data.length);
        System.out.println("arrays equal before sort: " + Arrays.equals(data, copy));
        Arrays.sort(data);
        System.out.println("arrays equal after sort: " + Arrays.equals(data, copy));
        System.out.println("copy = " + Arrays.toString(copy));
        System.out.println("data = " + Arrays.toString(data));
    }
}