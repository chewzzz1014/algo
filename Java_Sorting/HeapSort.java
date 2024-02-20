// implementation of heap sort
public class HeapSort {
	
	public void sort(int[] a) {
		for(int i=(a.length-1)/2; i>=0; i--) 
			heapify(a, i, a.length);
		
		for(int j=a.length-1; j>0; j--) {
			swap(a, 0, j);
			heapify(a, 0, j);
		}		
		
	}
	
	public void buildHeap(int[] a, int i, int n) {
		if (i >= n/2)
			return;
		
		// left node
		buildHeap(a, 2*i+1, n);
		// right node
		buildHeap(a, 2*i+2, n);
		heapify(a, i, n);
	}
	
	private void heapify(int[] a, int i, int n) {
		int ai = a[i];
		
		while(i < n/2) { // while a[i] is not a leaf
			int j = 2*i + 1; // left child
			
			//  a[j] is ai's larger child
			if (j+1<n && a[j+1]>a[j])
				++j;
			
			// a[j] is not out of order
			if(a[j] <= ai)
				break;
			
			a[i] = a[j];
			i = j;
			a[i] = ai;
		}
	}
	
	private void swap(int[] a,int x, int y) {
		int tmp;
		tmp = a[x];
		a[x] = a[y];
		a[y] = tmp;
	}
	
}
