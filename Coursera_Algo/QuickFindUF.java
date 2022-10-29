// implementation of Quick Find in Java
// to check if there's a path between 2 node (whether direct or indirect)
// connected nodes are in one components (kind of like set in maths). If 2 node are in the same component, there're connected.
// components are identified by id

class QuickFindUF {
		
		// component id for each element 
		private int[] id;
		
		// initially, each node is one component
		public QuickFindUF(int n) {
			id = new int[n];
			for (int i=0; i<n; i++)
				id[i] = i;
		}
		
		//check if p and q are in the same component
		public boolean connected(int p, int q) {
			return id[p] == id[q];
		}
		
		
		// merge components containing p and q
		// change all entries with id[p] to id[q] (at most 2n+2 array accesses)
		public void union(int p, int q) {
			int pid = id[p];
			int qid = id[q];
			for (int i=0; i<id.length; i++)
				if (id[i] == pid) id[i] = qid;
		}
		
		public static void main (String[]args) {
			System.out.print("Testing");
		}
}
