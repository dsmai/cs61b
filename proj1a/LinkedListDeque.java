public class LinkedListDeque<T> {
    // Implement deque using linked list

    // instance variables
    private Node sentinel;
    private int size;

    // Nested class
    public class Node {
        public Node prev;
        public T item;
        public Node next;

        // constructor
        public Node(T item, Node prev, Node next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    // Default constructor: empty deque
    public LinkedListDeque() {
        sentinel = new Node(null, null, null); // What to pass in as first parameter here?
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    public LinkedListDeque(T item) {
        Node newNode = new Node(item, null, null);
        sentinel = new Node(null, newNode, newNode);
        newNode.prev = sentinel;
        newNode.next = sentinel;
        size += 1;
    }

    // Copy constructor, pass in another LinkedListDeque
    public LinkedListDeque(LinkedListDeque lld) {
        this.sentinel = lld.sentinel;
        this.size = lld.size;
    }

    public void addFirst(T item) {
        Node newNode = new Node(item, sentinel, sentinel.next);
        sentinel.next.prev = newNode;
        sentinel.next = newNode;
        size += 1;
    }

    public void addLast(T item) {
        Node newNode = new Node(item, sentinel.prev, null);
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;
        size += 1;
    }

    public T removeFirst() {
        Node firstNode = sentinel.next;
        sentinel.next =  sentinel.next.next;
        sentinel.next.prev = sentinel;
        size -= 1;
        return firstNode.item; // need to think about null case?
    }

    public T removeLast() {
        Node lastNode = sentinel.prev;
        sentinel.prev.prev.next = null;
        sentinel.prev = sentinel.prev.prev;
        size -= 1;
        return lastNode.item;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public int size() {
        return size;
    }

    // non-destructive
    public T get(int index) {
        if (index >= size) {
            return null;
        } else {
            // Create pointer reference to "first" of deque, or index 0
            Node ptr = sentinel.next;

            //Use for loop to traverse the deque instead
            for (int i = 0; i < index; i++) {
                // travers the list by moving the pointer
                ptr = ptr.next;
            }
            return ptr.item;
        }
    }

    // Private helper method that remove first node
    private void removeFirstAnother() {
        Node firstNode = sentinel.next;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size -= 1;
    }

    // This looks like it is destructive.
    // New strategy, copy the linkedlistdeque to a new list (but removing the "first")
    public T getRecursiveAnother(int index) {
        // base case:
        if (index >= size) {
            return null;
        } else if (index == 0) {
            return sentinel.next.item;
        } else {
            // create a new deque (copy of the current deque)
            LinkedListDeque<T> newlld = new LinkedListDeque<>(this);
            newlld.removeFirstAnother(); // call this to pop first item from the newlld
            return newlld.getRecursive(index - 1); // call recursively on the newlld
        }
    }

    /** Return item at certain index, starting from "start" node */
    private T getRecursiveHelper(Node start, int index) {
        // base case: index = 0
        if (index == 0) {
            return start.item;
        } else {
            // call recursive, move pointer 1 next for everytime index decrease by 1, until reaches 0
            return getRecursiveHelper(start.next, index - 1);
        }
    }

    public T getRecursive(int index) {
        if (index >= size) {
            return null;
        }
        return getRecursiveHelper(sentinel.next, index);
    }

    public T getFirst() {
        return sentinel.next.item;
    }

    public T getLast() {
        return sentinel.prev.item;
    }

    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.print(get(i) + " ");
        }
        System.out.println();
    }
}