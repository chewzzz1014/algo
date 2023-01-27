
public class QuickSort {

	public void sort(int[] a, int p, int q) {
		// precondition: 0<=p<q<=a.length
		// postcondition: a[p...q-1] is in ascending order
		
		if (q-p<2)
			return;
		int j = partition(a, p, q);
		sort(a, p, j);
		sort(a, j+1, q);
	}
	
	// return index j of pivot element a[j]
	private int partition(int[] a, int p, int q) {
		// postcondition: a[i]<=a[j]<=a[k] for p<=i<=j<=k<=q
		
		int pivot = a[p];
		int i = p;
		int j = q;
		
		while (i<j) {
			while(j>i && a[--j]>=pivot) 
				; // empty loop
			
			if(j>i)
				a[i] = a[j];
			
			while(i<j && a[++i]<=pivot)
				; //empty loop
			
			if(i<j)
				a[j] = a[i];
		}
		a[j] = pivot;
		return j;
	}
	
}
