public class BSTNode<T> {
	 T data;
	 String key;
	 BSTNode<T> left, right;
	 int position;
	 
	 public BSTNode(T item, int position) {
	    data = item;
	    key = ((Software)(data)).key;
	    left = right = null;
	    this.position = position;
	 }
}
