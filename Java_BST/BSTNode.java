public class BSTNode<T> {
	 T data;
	 String key;
	 BSTNode<T> left, right;

	 public BSTNode(T item) {
	    data = item;
	   // key = (Software) data.key;
	    left = right = null;
	 }
}
