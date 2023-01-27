// Chew Zi Qing 212360

// BST Node with generic type
public class BSTNode<T> {
	 // for storing software info
	 T data;
	 // software's name + version
	 String key;
	 // left and right node
	 BinarySearchTreeNode<T> left, right;
	 // position in file
	 int position;
	 
	 public BSTNode(T item, int position) {
	    data = item;
	    key = ((Software)(data)).key;
	    left = right = null;
	    this.position = position;
	 }
}
