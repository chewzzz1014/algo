class BinarySearchTree<T>{
  BSTNode<T> root;

  BinarySearchTree() {
    root = null;
  }

  void insert(T key) {
    root = insertKey(root, key);
  }

  BSTNode<T> insertKey(BSTNode<T> root, T key) {
    // Return a new node if the tree is empty
    if (root == null) {
      root = new BSTNode<T>(key);
      return root;
    }

    int targetNodePrice = ((Software)(key)).price;
    int rootNodePrice = ((Software)(root.data)).price;
    // Traverse to the right place and insert the node
    if (targetNodePrice<rootNodePrice)
      root.left = insertKey(root.left, key);
    else if (targetNodePrice>rootNodePrice)
      root.right = insertKey(root.right, key);

    return root;
  }

  void inorder() {
    inorderRec(root);
  }

  // Inorder Traversal
  void inorderRec(BSTNode<T> root) {
    if (root != null) {
      inorderRec(root.left);
      System.out.print(root.data + " -> ");
      inorderRec(root.right);
    }
  }

  void deleteKey(T key) {
    root = deleteRec(root, key);
  }

  BSTNode<T> deleteRec(BSTNode<T> root, T key) {
    // Return if the tree is empty
    if (root == null)
      return root;

    // Find the node to be deleted
    int targetNodePrice = ((Software)(key)).price;
    int rootNodePrice = ((Software)(root.data)).price;
    
    if (targetNodePrice<rootNodePrice)
      root.left = deleteRec(root.left, key);
    else if (targetNodePrice<rootNodePrice)
      root.right = deleteRec(root.right, key);
    else {
      // If the node is with only one child or no child
      if (root.left == null)
        return root.right;
      else if (root.right == null)
        return root.left;

      // If the node has two children
      // Place the inorder successor in position of the node to be deleted
      root.data = minValue(root.right);

      // Delete the inorder successor
      root.right = deleteRec(root.right, root.data);
    }

    return root;
  }

  // Find the inorder successor
  T minValue(BSTNode<T> root) {
    T minv = root.data;
    while (root.left != null) {
      minv = root.left.data;
      root = root.left;
    }
    return minv;
  }


}
