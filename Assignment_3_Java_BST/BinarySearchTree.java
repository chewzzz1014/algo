// Chew Zi Qing 212360

// BST implementation
class BinarySearchTree<T>{
  final static String FILEPATH = "C:\\Users\\USER\\eclipse-workspace\\Algo_DS\\Java_BST\\Software.txt";
  final static String FILEPATH_TEMP = "C:\\Users\\USER\\eclipse-workspace\\Algo_DS\\Java_BST\\Software_tmp.txt";
  BinarySearchTreeNode<T> root;

  // start with empty BST
  BinarySearchTree() {
    root = null;
  }

  // insert a node in alphabetically ascending order
  void insert(T key, int pos) {
    root = insertKey(root, key, pos);
  }

  BinarySearchTreeNode<T> insertKey(BinarySearchTreeNode<T> root, T target, int pos) {
    // Return a new node if the tree is empty
    if (root == null) {
      root = new BinarySearchTreeNode<T>(target, pos);
      return root;
    }

    String targetNode = ((Software)(target)).key;
    String rootNode = ((Software)(root.data)).key;
    // add as left node if the key is alphabetically smaller
    if (targetNode.compareTo(rootNode)<0)
      root.left = insertKey(root.left, target, pos);
   // add as right node if the key is alphabetically larger
    else if (targetNode.compareTo(rootNode)>0)
      root.right = insertKey(root.right, target, pos);
    else {
    	// software already existed. Update quantity and price
    	((Software)(root.data)).quantity = ((Software)(target)).quantity;
    	((Software)(root.data)).price = ((Software)(target)).price;
    }
    return root;
  }

  // inorder traversal of BST
  void inorder() {
    inorderRec(root);
  }

  void inorderRec(BinarySearchTreeNode<T> root) {
    if (root != null) {
      inorderRec(root.left);
      System.out.print(root.key + " -> ");
      inorderRec(root.right);
    }
  }

  // delete a node from BST
  void deleteKey(T target) {
    root = deleteRec(root, target);
  }

  BinarySearchTreeNode<T> deleteRec(BinarySearchTreeNode<T> root, T target) {
    // if tree is empty
    if (root == null)
      return root;

    // delete node by its key
    String targetNode = ((Software)(target)).key;
    String rootNode = ((Software)(root.data)).key;
    
    if (targetNode.compareTo(rootNode)<0)
      root.left = deleteRec(root.left, target);
    else if (targetNode.compareTo(rootNode)>0)
      root.right = deleteRec(root.right, target);
    else {
     // the current node is the target node to be deleted
      if (root.left == null)
        return root.right;
      else if (root.right == null)
        return root.left;
      else {
    	  BinarySearchTreeNode<T> nodeSucc = findMin(root.right);
          root.data = nodeSucc.data;
          root.key = nodeSucc.key;
      }
    }
    return root;
  }

  // Find the inorder successor
  BinarySearchTreeNode<T> findMin(BinarySearchTreeNode<T> node){
	  while (node.left != null) {
		  node = node.left;
	  }
	  return node;
  }
  
  // search node given a Software object
  public BinarySearchTreeNode<T> search(T target) {
	 return searchRec(root, target);
  }
  
  // Overloading method
  // search node given Software name
  public BinarySearchTreeNode<T> search(String name) {
		 return searchRec(root, name);
  }
  
  public BinarySearchTreeNode<T> searchRec(BinarySearchTreeNode<T> root, T target)
  {
      if (root==null || root.key.equals(((Software)(target)).key))
          return root;
   
      String targetNode = ((Software)(target)).key;
      String rootNode = ((Software)(root.data)).key;
      if (targetNode.compareTo(rootNode)<0)
         return searchRec(root.left, target);
      else if (targetNode.compareTo(rootNode)>0)
    	 return searchRec(root.right, target);
      else
    	  return root;
  }
  
  // overloading method
  // search node given Software name
  public BinarySearchTreeNode<T> searchRec(BinarySearchTreeNode<T> root, String name)
  {
      if (root==null)
          return null;
   
      String rootNode = ((Software)(root.data)).name;
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
  // print all node in BST
  private void printInventory(BinarySearchTreeNode<T> node) {
	    if (node == null) {
	      return;
	    }
	    printInventory(node.left);
	    System.out.println(((Software)(node.data)).toString());
	    System.out.println();
	    printInventory(node.right);
}
 
  // remove any Software with quantity = 0
  // read from Software.txt and write updated Software info into Software_tmp.txt
  // Rename Software_tmp.txt to Software.txt and delete the old Software.txt
  public void updateFile() throws java.io.IOException {
	  java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.FileReader(FILEPATH));
	  java.io.BufferedWriter writer = new java.io.BufferedWriter(new java.io.FileWriter(FILEPATH_TEMP));

	    String line;
	    int pos = 0;
	    while ((line = reader.readLine()) != null) {
	      String[] parts = line.split(",");
	      int quantity = Integer.parseInt(parts[2]);
	      if (quantity > 0) {
	        writer.write(line+"\n");
	      }
	      else {
	        // skip Software with quantity = 0
	        continue;
	      }
	      pos += line.length() + 1;
	    }
	    reader.close();
	    writer.close();

	    // replace software with cleaned up file
	    // we end up with Software.txt only
	    java.io.File oldFile = new java.io.File(FILEPATH);
	    java.io.File newFile = new java.io.File(FILEPATH_TEMP);
	    if (oldFile.delete()) {
	      newFile.renameTo(oldFile);
	    }
	  }

}
