public class IntNode {
    public int item;
    public IntNode next;
    public IntNode prev; // This makes our list have 2 links for every node (Doubly linked list)

    // constructor
    public IntNode(int i, IntNode n) {
        item = i;
        next = n;
    }
}