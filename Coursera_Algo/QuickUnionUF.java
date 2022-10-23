// lazy approach
// implementation of Quick Union in Java
// to check if there's a path between 2 node (whether direct or indirect)
// each components (set of connected nodes) has a root
// each connected node has a parent
// to check if 2 nodes are connected, check whether their root are the same (by referencing parent of parent of parent...)

public class QuickUnionUF {
	private int[] id;
	
	// set id of each object to itself
	public QuickUnionUF(int n) {
		id = new int[n];
		for (int i=0; i<n; i++) id[i] = i;
	}
	
	
	// chase parent pointers until each root
	private int root(int i) {
		while (i != id[i])
			i = id[i];
		return i;
	}
	
	// check if p and q have the same root (depth of p and q array accesses)
	public boolean connected(int p, int q) {
		return root(p) == root(q);
	}
	
	// change root of p to points to root of q (depth of p and q array accesses)
	public void union(int p, int q) {
		int i = root(p);
		int j = root(q);
		id[i] = j;
	}
}
