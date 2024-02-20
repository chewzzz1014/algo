
public class MergeSort {
	
	public void sort(int[] a, int p, int q) {
		// precondition: 0<=p<q<=a.length
		// postcondition: a[p...q-1] is in ascending order
		
		if(q-p < 2)
			return;
		int m = (p+q)/2;
		sort(a, p, m);
		sort(a, m, q);
		merge(a, p, m, q);
	}
	
	public void merge(int[] a, int p, int m, int q) {
		// precondition: a[p...m-1] and a[m...q-1] are in ascending order
		// postcondition: a[p...q-1] is in ascending order
		if (a[m-1]<=a[m])
			return;
		
		int i = p;
		int j = m;
		int k = 0;
		int[] aa = new int[q-p];
		
		while(i<m && j<q) {
			if(a[i]<a[j])
				aa[k++] = a[i++];
			else
				aa[k++] = a[j++];
			
			if (i<m)
				System.arraycopy(a,  i,  a,  p+k,  m-1);
			System.arraycopy(aa,  0, a, p, k);
		}
	}
	
}
