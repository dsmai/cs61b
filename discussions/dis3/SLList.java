public class SLList {
    // Nest private class
    private class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int item, IntNode next) {
            this.item = item;
            this.next = next;
        }
    }

    // Default constructor
    public SLList() {
        size = 0;
        sentinel = new IntNode(999, null);
    }

    // fields
    private int size;
    private IntNode sentinel;

    // methods

    public void print() {
        // Starting from sentinel node
        IntNode ptr = sentinel;
        while (ptr.next != null) {
            ptr = ptr.next;
            System.out.print(ptr.item);
        }
    }

    public int getSize() {
        return size;
    }

    public int recursiveSize() {
        return -1;
    }

    public int iterativeSize() {
        return -1;
    }

    public void addFirst(int item) {
        IntNode newNode = new IntNode(item, sentinel.next);
        sentinel.next = newNode;
        size++;
    }

    public void removeFirst() {
        if (size == 0) {
            System.out.println("Invalid, list is empty");
            return;
        }
        sentinel.next = sentinel.next.next;
        size--;
    }

    public int removeFirstItem() {
        if (size == 0) {
            System.out.println("Invalid, list is empty");
            return -1;
        }
        IntNode firstNode = sentinel.next;
        sentinel.next = sentinel.next.next;
        size--;
        return firstNode.item;
    }

    public int getFirst() {
        if (size == 0) {
            System.out.println("Invalid, list is empty");
            return -1;
        }
        return sentinel.next.item;
    }

    // O(n) because have to iterate through the list
    // Return null if list is empty
    private IntNode getLastNode() {
        // Need to iterate to the end of the list
        // until ptr.next is null

        // starting from sentinel node
        IntNode ptr = sentinel;
        while (ptr.next != null) {
            // advance ptr if the next node is not null
            ptr = ptr.next;
        }
        return ptr;
    }

    // O(n) because depends on getLastNode()
    public void addLast(int item) {
        IntNode lastNode = getLastNode();

        // out of the while loop, we are at the last node
        lastNode.next = new IntNode(item, null);
        size++;
    }

    public void removeLast() {
        if (size == 0) {
            System.out.println("Invalid, list is empty");
        }

        // Need to iterate to "second to last"
        // NULL next of second to last node
        IntNode ptr = sentinel;
        while (ptr.next != null) { // check to safely go to next
            if (ptr.next.next == null) {
                break;
            }
            ptr = ptr.next;
        }

        // exiting the while loop, we are at the second-to-last node
        ptr.next = null;
        size--;
    }

    public int removeLastItem() {
        if (size == 0) {
            System.out.println("Invalid, list is empty");
            return -1;
        }

        // Need to iterate to "second to last"
        // NULL next of second to last node
        IntNode ptr = sentinel;
        while (ptr.next != null) { // check to safely go to next
            if (ptr.next.next == null) {
                break;
            }
            ptr = ptr.next;
        }

        // exiting the while loop, we are at the second-to-last node
        IntNode lastNode = ptr.next;
        ptr.next = null;
        size--;
        return lastNode.item;
    }

    public int getLast() {
        return getLastNode().item;
    }

    // Private helper method to return a node at specfic index position
    public IntNode getNode(int position) {
        // Check edge case
        if (position >= size) {
            return null;
        }
        // Need a counter to count
        // Starting at sentinel node
        IntNode ptr = sentinel;
        for (int i = -1; i < position; i++) {
            ptr = ptr.next;
        }
        return ptr; // this will return sentinel if position is invalid like -3
    }

    public int getItem(int position) {
        if (position >= size) {
            return -999;
        }
        return getNode(position).item;
    }

    public void insert(int item, int position) {
        if (position > size) {
            System.out.println("Invalid position. Position >= Size of list");
            return;
        }
        // Iterate to Node at "position" index. Let's call it currentNode
        IntNode currentNode = getNode(position);
        // Create a new node that points to currentNode.next
        IntNode newNode = new IntNode(item, currentNode);
        // Update next of the node previous to it
        getNode(position - 1).next = newNode;
        size++;
    }

    // Method to convert a linkedlist to array
    public int[] toArray() {
        IntNode ptr = sentinel.next;
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ptr.item;
            ptr = ptr.next;
        }
        return arr;
    }

    // destructive reverse
    public void reverse() {
        IntNode ptr = sentinel;
        int originalSize = size;

        IntNode firstNodeAdded = null;
        for (int i = 0; i < originalSize; i++) {
            ptr = ptr.next;
            addFirst(ptr.item);
            if (i == 0) {
                // Keep track of the first node added
                firstNodeAdded = sentinel.next;
            }
        }

        ptr = null;

        // cut the old list "loose"
        firstNodeAdded.next = null;

        // update the size
        size = size / 2;
    }

    // non-destructive reverse
    // return a new linked list
    public SLList reverseNonDestructive() {
        IntNode ptr = sentinel;
        SLList newList = new SLList();
        while (ptr.next != null) {
            ptr = ptr.next;
            newList.addFirst(ptr.item);
        }
        return newList;
    }

    public void reverseRecursive() {
        sentinel.next = recursiveHelper(sentinel.next);
    }

    // private helper for recursive reverse
    private IntNode recursiveHelper(IntNode front) {
        if (front == null || front.next == null) {
            // base case
            return front;
        } else {
            IntNode reversed = recursiveHelper(front.next);
            front.next.next = front;
            front.next = null;
            return reversed;
        }
    }
}