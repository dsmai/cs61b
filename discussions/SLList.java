public class SLList {
    // modify "first" to private so that it is more secure (cannot modify directly like L.first.next.next = L.first.next)
    // "first" now can only be accessed from the SLList
    private IntNode first;   // the address of the head of the linked list (cached)
    private int size;         // sacrefice some memories, but can access quickly in constant time. Caching "size" (cached)
    private IntNode sentinel; // a special node that is always there in the beginning (to make empty and regular linked list behave the same)
    private IntNode last;     // the address of the tail of the linked list (cached)

    // Nested class
    public static class IntNode {
        public int item;
        public IntNode next;
        public IntNode prev; // This makes our list have 2 links for every node (Doubly linked list)
    
        // constructor
        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    // default constructor, empty list
    public SLList() {
        first = null;
        sentinel = new IntNode(-999, first); // by default, when create empty list, sentinel node always points to "first" or head of list
        last = null;
        size = 0;
    }

    // constructor
    public SLList(int number) {
        first = new IntNode(number, null);
        sentinel = new IntNode(-999, first); // by default, when create empty list, sentinel node always points to "first" or head of list
        last = first;
        size = 1;
    }

    public void addFirst(int number) {
        first = new IntNode(number, first);
        sentinel.next = first; // update sentinel.next so sentinel points to the "new" first
        size += 1;
    }

    public void removeFirst() {
        sentinel.next = first.next;
        first = sentinel.next;
        size -= 1;
    }

    public int getFirst() {
        return first.item;
    }

    public int getLast() {
        return last.item;
    }

    public int getSentinel() {
        return sentinel.item;
    }

    public void addLast(int number) {
        last.next = new IntNode(number, null);
        // move the "last" pointer 1 increment
        last = last.next;
        size += 1;
    }

    public void removeLast() {
        last.next = null;
    }

    public void addLastIterative(int number) {

        // condition to prevent NullPointerException? (because we check ptr.next, what if ptr is null?)
        // Now because there is a sentinel node, does not need to care about special case where ptr is null

        IntNode ptr = sentinel; // create a pointer to iterate.
        // Advance pointer ptr to the end of the list
        while (ptr.next != null) {
            ptr = ptr.next;
        }
        // when out of while loop, we are at the last node
        ptr.next = new IntNode(number, null);

        last = ptr.next;

        size += 1;
    }

    /** Helper method to do add last recrusive, to interact with the underlying naked recursive data structure */
    /** Add to the list after node IntNode ptr */
    private void addNode(IntNode ptr, int number) {
        // base case: empty list
        if (ptr.next == null) {
            ptr.next = new IntNode(number, null);
            return;
        }
        addNode(ptr.next, number);
    }

    public void addLastRecursive(int number) {

        // wrong code were commented out, because sizeRecursive() is a method of SLList, not IntNode. 
        // // condition to prevent NullPointerException?
        // // Now because there is a sentinel node, does not need to care about special case where ptr is null

        // // base case, empty list
        // if (sentinel.next == null) {
        //     sentinel.next = new IntNode(number, null);
        // }
        // sentinel.next.addLastRecursive(number); // wrong here, because sentinel.next is an IntNode type, not SLList type!

        // Want to call
        addNode(sentinel, number);
        size += 1;
    }

    /** Private helper method that interacts with the underlying naked data structure of IntNode */
    /** Return the size of the list starting at IntNode ptr */
    private static int size(IntNode ptr) {
        // think about edge case, what is ptr is null? => nullPointerException
        // base case: ptr.next == null, return 1
        if (ptr == null) {
            System.out.println("Invalid node.");
            return -1;
        } else {
            if (ptr.next == null) {
                return 1;
            }
            return 1 + size(ptr.next);
        }
    }

    public int size() {
        // return size(first); // using the above static helper method (slow)
        return size; // USE CACHING to save frequently accessed data, very fast, constant time access
    }

    public int sizeIterative() {
        int totalSize = 0;
        IntNode ptr = first; // pointer to traverse the list
        while (ptr != null) {
            totalSize++;
            ptr = ptr.next; // traverse the linked list
        }
        return totalSize;
    }

    /** Private helper method */
    // Return size of list starting from a given node
    private static int sizeRecursive(IntNode ptr) {
        if (ptr.next == null) {
            return 0;
        }
        return 1 + sizeRecursive(ptr.next);
    }

    // wrong code, because sizeRecursive() is a method of SLList, not IntNode. 
    // public int sizeRecursive() {
    //     // base case: .next is null, return 1 (last node)
    //     // Fun: what if first is null? => NullPtrException
    //     if (first.next == null) {
    //         return 1;
    //     }
    //     // recursive call using first.next (move pointer to the next position)
    //     return 1 + first.next.sizeRecursive(); // wrong here, because first.next is an IntNode type, not SLList type!
    // }

    public int sizeRecursive() {
        return sizeRecursive(sentinel); // Starting from sentinel
    }
}