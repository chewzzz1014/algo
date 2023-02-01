
public class ShellSort {
	public void iSort(int[] a, int c, int d) {
		for(int i=c+d; i<a.length; i+=d) {
			int ai = a[i];
			int j = i;
			while(j>c && a[j-d]>ai) {
				a[j] = a[j-d];
				j -= d;
			}
			a[j] = ai;
		}
	}
	
	public void sort(int[]a) {
		for(int d = a.length/2; d>0; d/=2)
			for(int c=0; c<d; c++)
				iSort(a, c, d);
	}
}
