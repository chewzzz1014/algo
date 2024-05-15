package SearchTree;

import List.Position;
import PriorityQueue.Entry;
import Tree.LinkedBinaryTree;

public class BalanceableBinaryTree<K, V> extends LinkedBinaryTree<Entry<K,V>> {

    // nested BSTNode
    protected static class BSTNode<T> extends Node<T> {
        int aux = 0;
        BSTNode(T t, Node<T> parent, Node<T> leftChild, Node<T> rightChild) {
            super(t, parent, leftChild, rightChild);
        }
        public int getAux() {return aux;}
        public void setAux(int value) {aux = value;} 
    }
    // end of nested BSTNode

    public int getAux(Position<Entry<K,V>> p) {
        return ((BSTNode<Entry<K,V>>) p).getAux();
    }

    public void setAux(Position<Entry<K,V>> p, int value) {
        ((BSTNode<Entry<K,V>>) p).setAux(value);
    }

    protected Node<Entry<K,V>> createNode(Entry<K,V> t, Node<Entry<K,V>> parent, Node<Entry<K,V>> left, Node<Entry<K,V>> right) {
        return new BSTNode<>(t, parent, left, right);
    }

    private void relink(Node<Entry<K,V>> parent, Node<Entry<K,V>> child, boolean makeLeftChild) {
        child.setParent(parent);
        if(makeLeftChild)
            parent.setLeft(child);
        else 
            parent.setRight(child);
    }

    public void rotate(Position<Entry<K,V>> p) {
        // x -> y (parent) -> z (grandparent)
        Node<Entry<K,V>> x = validate(p);
        Node<Entry<K,V>> y = x.getParent();
        Node<Entry<K,V>> z = y.getParent();

        // x become direct child of z
        if(z == null) { // if root is null
            root = x;
            x.setParent(null);
        } else {
            relink(z, x, y == z.getLeft());
        }

        // rotate x and y, include transfer of middle subtree
        if(x == y.getLeft()) {
            // x'right child become y's left child
            // y becomes x's right child
            relink(y, x.getRight(), true);
            relink(x, y, false);
        } else {
            relink(y, x.getLeft(), false);
            relink(x, y, true);
        }
    }

    // trinode restructure position x with its parent/grandparent
    public Position<Entry<K,V>> restructure(Position<Entry<K,V>> x) {
        Position<Entry<K,V>> y = parent(x);
        Position<Entry<K,V>> z = parent(y);
        // if matching alignment -> single rotation
        if((x == right(y)) == (y == right(z))) {
            rotate(y);
            return y;
        } else {
            rotate(x);
            rotate(x);
            return x;
        }
    }
}
