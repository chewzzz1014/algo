// implementation of insertion sort
public class InsertionSort {
	
	public void sort(int[] a) {
		// starting from 1, 2, 3.....
		for(int i=1; i<a.length; i++) {
			int ai = a[i];
			int j = i;
			
			// sort the sequence before i
			for(j=i; j>0 && a[j-1]>ai; j--) {
				a[j] = a[j-1];
				a[j] = ai;
			}
		}
	}
	
}
