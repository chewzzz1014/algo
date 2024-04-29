package topInterview150;

public class PopulateNextRightPointers2 {
    public Node connect(Node root) {
        Node dummyHead = new Node(0);
        Node temp = root;
        Node pre = dummyHead; // current node that build every single layer

        while(root != null) {
            if(root.left != null) {
                pre.next = root.left;
                pre = pre.next;
            }
            if(root.right != null) {
                pre.next = root.right;
                pre = pre.next;
            }
            root = root.next;
            if(root == null) { // reach the end of current layer
                pre = dummyHead; // shift pre back to the beginning, get ready to point to the first element in next layer  
                root = dummyHead.next; ;//root comes down one level below to the first available non null node
                dummyHead.next = null;//reset dummyhead back to default null
            }
        }

        return temp;   
    }
}
