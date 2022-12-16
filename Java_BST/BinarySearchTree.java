class BinarySearchTree<T>{
  BSTNode<T> root;

  BinarySearchTree() {
    root = null;
  }

  void insert(T key, int pos) {
    root = insertKey(root, key, pos);
  }

  BSTNode<T> insertKey(BSTNode<T> root, T target, int pos) {
    // Return a new node if the tree is empty
    if (root == null) {
      root = new BSTNode<T>(target, pos);
      return root;
    }

    String targetNode = ((Software)(target)).key;
    String rootNode = ((Software)(root.data)).key;
    // Traverse to the right place and insert the node
    if (targetNode.compareTo(rootNode)<0)
      root.left = insertKey(root.left, target, pos);
    else if (targetNode.compareTo(rootNode)>0)
      root.right = insertKey(root.right, target, pos);
    else {
    	// software already existed. update quantity and price
    	((Software)(root.data)).quantity = ((Software)(target)).quantity;
    	((Software)(root.data)).price = ((Software)(target)).price;
    }

    return root;
  }

  void inorder() {
    inorderRec(root);
  }

  // Inorder Traversal
  void inorderRec(BSTNode<T> root) {
    if (root != null) {
      inorderRec(root.left);
      System.out.print(root.key + " -> ");
      inorderRec(root.right);
    }
  }

  void deleteKey(T target) {
    root = deleteRec(root, target);
  }

  BSTNode<T> deleteRec(BSTNode<T> root, T target) {
    // Return if the tree is empty
    if (root == null)
      return root;

    // Find the node to be deleted
    String targetNode = ((Software)(target)).key;
    String rootNode = ((Software)(root.data)).key;
    
    if (targetNode.compareTo(rootNode)<0)
      root.left = deleteRec(root.left, target);
    else if (targetNode.compareTo(rootNode)>0)
      root.right = deleteRec(root.right, target);
    else {
      // If the node is with only one child or no child
      if (root.left == null)
        return root.right;
      else if (root.right == null)
        return root.left;
      else {
    	  BSTNode<T> nodeSucc = findMin(root.right);
          root.data = nodeSucc.data;
          root.key = nodeSucc.key;
      }
    }

    return root;
  }

  // Find the inorder successor
  BSTNode<T> findMin(BSTNode<T> node){
	  while (node.left != null) {
		  node = node.left;
	  }
	  return node;
  }
  
  public BSTNode<T> search(T target) {
	 return searchRec(root, target);
  }
  
  // Overloading method
  public BSTNode<T> search(String name) {
		 return searchRec(root, name);
  }
  
  public BSTNode<T> searchRec(BSTNode<T> root, T target)
  {
      // Base Cases: root is null or key is present at root
      if (root==null || root.key.equals(((Software)(target)).key))
          return root;
   
      String targetNode = ((Software)(target)).key;
      String rootNode = ((Software)(root.data)).key;
      // Key is greater than root's key
      if (targetNode.compareTo(rootNode)<0)
         return searchRec(root.left, target);
      else if (targetNode.compareTo(rootNode)>0)
    	 return searchRec(root.right, target);
      else
    	  return root;
  }
  
  // overloading
  public BSTNode<T> searchRec(BSTNode<T> root, String name)
  {
      // Base Cases: root is null or key is present at root
      if (root==null)
          return null;
   
      String rootNode = ((Software)(root.data)).name;
      // Key is greater than root's key
      if (name.compareTo(rootNode)<0)
         return searchRec(root.left, name);
      else if (name.compareTo(rootNode)>0)
    	 return searchRec(root.right, name);
      else
    	  return root;
  }
  
  public void printInventory() {
	    printInventory(root);
  }

  private void printInventory(BSTNode<T> node) {
	    if (node == null) {
	      return;
	    }
	    printInventory(node.left);
	    System.out.println(((Software)(node.data)).toString());
	    System.out.println();
	    printInventory(node.right);
}
  
  public void updateFile() throws java.io.IOException {
	  java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.FileReader("C:\\Users\\USER\\eclipse-workspace\\Algo_DS\\Java_BST\\Software.txt"));
	  java.io.BufferedWriter writer = new java.io.BufferedWriter(new java.io.FileWriter("C:\\Users\\USER\\eclipse-workspace\\Algo_DS\\Java_BST\\Software_tmp.txt"));

	    String line;
	    int pos = 0;
	    while ((line = reader.readLine()) != null) {
	      String[] parts = line.split(",");
	      int quantity = Integer.parseInt(parts[2]);
	      if (quantity > 0) {
	        writer.write(line+"\n");
	      }
	      else {
	        // skip entries with 0 quantity
	        continue;
	      }
	      pos += line.length() + 1;
	    }
	    reader.close();
	    writer.close();

	    // replace software with cleaned up file
	    // we end up with Software.txt only
	    java.io.File oldFile = new java.io.File("C:\\Users\\USER\\eclipse-workspace\\Algo_DS\\Java_BST\\Software.txt");
	    java.io.File newFile = new java.io.File("C:\\Users\\USER\\eclipse-workspace\\Algo_DS\\Java_BST\\Software_tmp.txt");
	    if (oldFile.delete()) {
	      newFile.renameTo(oldFile);
	    }
	  }

}
