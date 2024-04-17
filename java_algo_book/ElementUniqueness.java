import java.util.Arrays;

public class ElementUniqueness {
    
    public static boolean unique1(int[] data) {
        int n = data.length;
        for(int i=0; i<n-1; i++)
            for(int j=i+1; j<n; j++)
                if(data[i] == data[j])
                    return false;
        return true;
    }

    public static boolean unique2(int[] data) {
        int n = data.length;
        int[] temp = Arrays.copyOf(data, n);

        Arrays.sort(temp); // O(nlog n)

        for(int i=0; i<n-1; i++)
            if(temp[i] == temp[i+1])
                return false;

        return true;
    }
}
