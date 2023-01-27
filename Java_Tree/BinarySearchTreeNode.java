// implementation of binary search tree

public class BinarySearchTreeNode {
	Object root;
	BinarySearchTreeNode left, right;
	
	// constructor
	BinarySearchTreeNode(Object root){
		this.root = null;
	}
	
	// destroy BST: delete all data and recycle the memory
	public void destroyTree(BinarySearchTreeNode pWalk) {
		if (pWalk != null) {
			destroyTree(pWalk.left);
			destroyTree(pWalk.right);
			pWalk = null;
		}
	}
	
	// is the bst empty?
	public boolean isEmpty() {
		return root == null;
	}
	
	// insert new node into bst
	public void insertBST(int newItem) {
		boolean found = false;
		BinarySearchTreeNode pWalk = this.root;
		BinarySearchTreeNode parent = null;
		
		for(;;) {
			// found the location to insert the node
			if (found || pWalk==null)
				break;
			
			parent = pWalk;
			if(newItem<pWalk.data)
		}
	}
	
	
}
