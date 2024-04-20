import java.util.Stack;
import java_algo_book.ArrayStack;

public class ReverseArray {
    

    public static void reverseArray1(int[] data, int low, int high) {
        if(low < high) {
            int temp = data[low];
            data[low] = data[high];
            data[high] = temp;
            reverseArray(data, low + 1, high - 1);
        }
    }

    // using stack
    public static<T> void reverseArray2(T[] data) {
        Stack<T> buffer = new ArrayStack<>(data.length);

        for(T ele : data)
            buffer.push(ele);

        for(int i=0; i<data.length; i++)
            data[i] = buffer.pop();
    }
}
