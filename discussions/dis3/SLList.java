public class SLList {
    private class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int item, IntNode next) {
            this.item = item;
            this.next = next;
        }
    }

    private IntNode sentinel; // a node that is always there
    private int size;

    public SLList() {
        size = 0;
        sentinel = new IntNode(999, null);
    }

    public int getSize() {
        return size;
    }

    public void addFirst(int item) {
        sentinel.next = new IntNode(item, sentinel.next);
        size++;
    }

    // Helper method to return Node at a certain position
    public IntNode getNode(int position) {
        if (position >= size) {
            return null;
        }

        // traverse the linkedlist, O(n)
        IntNode ptr = sentinel;
        int location = -1;
        while (location < position) {
            ptr = ptr.next;
            location++;
        }
        return ptr;
    }

    public int getItem(int position) {
        if (position >= size) {
            return -999;
        }
        return getNode(position).item;
    }

    public void insert(int item, int position) {
        if (position > size) {
            System.out.println("Invalid index, try another.");
            return;
        }
        IntNode newNode = new IntNode(item, getNode(position));

        // Update "next" of the one previous to it
        getNode(position - 1).next = newNode;
        size++;
    }

    // Destructive method that reverse the list
    public void reverse() {

    }
}