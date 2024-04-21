package java_algo_book;

public class InsertionSort {

    public static void insertionSort(char[] data) {
        int n = data.length;

        for(int i=1; i<n; i++) {
            char current = data[i];
            int j = i;
            
            // shift to those >current to right
            while(j>0 && data[j-1]>current) {
                data[j] = data[j-1];
                j--;
            }
            data[j] = current;
        }
    }
    
    public static void insertionSort(PositionalList<Integer> list) {
        Position<Integer> marker = list.first();

        while(marker != list.last()) {
            Position<Integer> pivot = list.after(marker);
            int value = pivot.getElement();
            if (value > marker.getElement()) {
                marker = pivot;
            } else {
                Position<Integer> walk = marker;
                while(walk != list.first() && list.before(walk).getElement() > value)
                    walk = list.before(walk);
                list.remove(pivot);
                list.addBefore(walk, value);
            }
        }
    }
}
