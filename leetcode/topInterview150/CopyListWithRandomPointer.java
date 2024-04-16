package topInterview150;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        /*
        1. Iterate the original list and duplicate each node. The duplicate of each node follows its original immediately.
        2. Iterate the new list and assign the random pointer for each
duplicated node.
        3.Restore the original list and extract the duplicated nodes.
        */

        Node iter = head, next;

        // 1. make copy of each node and place to its next
        while(iter != null) {
            next = iter.next;

            Node copy = new Node(iter.val);
            iter.next = copy;
            copy.next = next;
            iter = next;
        }

        // 2. assign random pointers for the copy node
        iter = head;
        while (iter != null) {
            if(iter.random != null)
                iter.next.random = iter.random.next;
            iter = iter.next.next;
        }

        // 3. restore ori list and extract copy list
        iter = head;
        Node dummyHead = new Node(0);
        Node copy, copyIter = dummyHead;
        while(iter != null) {
            next = iter.next.next;

            //extract copy
            copy = iter.next;
            copyIter.next = copy;
            copyIter = copy;

            // restore ori list
            iter.next = next;

            iter = next;
        }

        return dummyHead.next;

    }
}
