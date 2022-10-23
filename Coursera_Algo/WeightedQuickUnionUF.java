// improvement: avoid large tree has smaller tree as parent (which result in unbalanced tree

public class WeightedQuickUnionUF {
	
	private int[] id;
	// size of tree
	private int[] sz;
	
	// set id of each object to itself
	public WeightedQuickUnionUF(int n) {
		id = new int[n];
		for (int i=0; i<n; i++) id[i] = i;
	}
	
	
	// chase parent pointers until each root
	private int root(int i) {
		while (i != id[i])
			i = id[i];	// move up to its parent
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

        // modification here
		if (i == j)
			return;
		if (sz[i]<sz[j]) {
			id[i] = j;
			sz[j] += sz[i]; // increase size of tree
		}
		else {
			id[j] = i;
			sz[i] += sz[j];  // increase size of tree
		}
	}
}
