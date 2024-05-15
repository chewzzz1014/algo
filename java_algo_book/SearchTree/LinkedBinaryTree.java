package SearchTree;

import List.Position;
import Tree.AbstractBinaryTree;

public class LinkedBinaryTree<T> extends AbstractBinaryTree<T> {
    
    // nested class: Node
    protected static class Node<T> implements Position<T> {
        private T element;
        private Node<T> parent;
        private Node<T> left;
        private Node<T> right;
        public Node(T ele, Node<T> above, Node<T> leftChild, Node<T> rightChild) {
            element = ele;
            parent = above;
            left = leftChild;
            right = rightChild;
        }
        public T getElement() {
            return element;
        }
        public Node<T> getParent() {
            return parent;
        }
        public Node<T> getLeft() {
            return left;
        }
        public Node<T> getRight() {
            return right;
        }
        public void setElement(T ele) {
            element = ele;
        }
        public void setParent(Node<T> parentNode) {
            parent = parentNode;
        }
        public void setLeft(Node<T> leftChild) {
            left = leftChild;
        }
        public void setRight(Node<T> rightChild) {
            right = rightChild;
        }
    }
    // end of nested class: Node

    // factory function to create new node storing ele
    protected Node<T> createNode(T ele, Node<T> parent, Node<T> left, Node<T> right) {
        return new Node<T>(ele, parent, left, right);
    }

    // instance variable
    protected Node<T> root = null;
    private int size = 0;

    // constructor
    public LinkedBinaryTree() {

    }

    // validate the position and return as a node
    protected Node<T> validate(Position<T> p) throws IllegalArgumentException {
        if(!(p instanceof Node))
            throw new IllegalArgumentException("Not valid position type");
        Node<T> node = (Node<T>) p;
        if(node.getParent() == node)
            throw new IllegalArgumentException("p is no longer in the tree");
        return node;
    }

    public int size() {
        return size;
    }

    public Position<T> root() {
        return root;
    }

    public Position<T> parent(Position<T> p) throws IllegalArgumentException {
        Node<T> node = validate(p);
        return node.getParent();
    }

    public Position<T> left(Position<T> p) throws IllegalArgumentException {
        Node<T> node = validate(p);
        return node.getLeft();
    }

    public Position<T> right(Position<T> p) throws IllegalArgumentException {
        Node<T> node = validate(p);
        return node.getRight();
    }

    public Position<T> addRoot(T ele) throws IllegalStateException {
        if(!isEmpty())
            throw new IllegalStateException("Tree is not empty");
        root = createNode(ele, root, root, root);
        size = 1;
        return root;
    }

    public Position<T> addLeft(Position<T> p, T ele) throws IllegalArgumentException {
        Node<T> parent = validate(p);
        if(parent.getLeft() != null)
            throw new IllegalArgumentException("p already has a left child");
        Node<T> child = createNode(ele, parent, null, null);
        parent.setLeft(child);
        size++;
        return child;
    }

    public Position<T> addRight(Position<T> p, T ele) throws IllegalArgumentException {
        Node<T> parent = validate(p);
        if(parent.getRight() != null)
            throw new IllegalArgumentException("p already has a right child");
        Node<T> child = createNode(ele, parent, null, null);
        parent.setRight(child);
        size++;
        return child;
    }

    public T set(Position<T> p, T ele) throws IllegalArgumentException {
        Node<T> node = validate(p);
        T temp = node.getElement();
        node.setElement(ele);
        return temp;
    }

    public void attach(Position<T> p, LinkedBinaryTree<T> t1, LinkedBinaryTree<T> t2) throws IllegalArgumentException {
        Node<T> node = validate(p);
        if(isInternal(node))
            throw new IllegalArgumentException("p must be a left");
        size += t1.size() + t2.size();
        if(!t1.isEmpty()) {
            t1.root.setParent(node);
            node.setLeft(t1.root);
            t1.root = null;
            t2.size = 0;
        }
        if(!t2.isEmpty()) {
            t2.root.setParent(node);
            node.setRight(t2.root);
            t2.root = null;
            t2.size = 0;
        }
    }

    // remove node at position p and replaces it with its child (if any)
    public T remove(Position<T> p) throws IllegalArgumentException {
        Node<T> node = validate(p);
        if(numChildren(p) == 2)
            throw new IllegalArgumentException("p has two children");
        Node<T> child = (node.getLeft() != null ? node.getLeft() : node.getRight());
        if(child != null)
            child.setParent(node.getParent());
        if(node == root)
            root = child;
        else {
            Node<T> parent = node.getParent();
            if(node == parent.getLeft())
                parent.setLeft(child);
            else
                parent.setRight(child);
        }
        size--;
        T temp = node.getElement();
        // for garbage collection
        node.setElement(null);
        node.setLeft(null);
        node.setRight(null);
        node.setParent(node);
        return temp;
    }
}

