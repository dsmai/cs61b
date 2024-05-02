public class LinkedListDeque<T> implements Deque<T> {
    // Implement deque using linked list

    // instance variables
    private Node sentinel;
    private int size;

    // Nested class
    private class Node {
        private Node prev;
        private T item;
        private Node next;

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

//    public LinkedListDeque(T item) {
//        Node newNode = new Node(item, null, null);
//        sentinel = new Node(null, newNode, newNode);
//        newNode.prev = sentinel;
//        newNode.next = sentinel;
//        size += 1;
//    }

//    // Deep Copy constructor, pass in another LinkedListDeque.
//    // The result should be a completely different object
//    // Modification to the new linkedlistdeque should not change the orignal one
//    public LinkedListDeque(LinkedListDeque other) {
//        this(); // invoke the default constructor explicitly
//
//        // assign the original first to ptr
//        Node ptr = other.sentinel.next;
//
//        // have to traverse the entire list, and copy node.item one by one
//        for (int i = 0; i < other.size; i++) {
//            // Create the next new node, behaves like addLast
//            this.addLast(ptr.item);
//            // advance pointer original
//            ptr = ptr.next;
//        }
//    }

    @Override
    public void addFirst(T item) {
        // Create a new node
        Node newNode = new Node(item, sentinel, sentinel.next);

        // link the current nodes to the new node
        sentinel.next.prev = newNode;
        sentinel.next = newNode;
        size += 1;
    }

    @Override
    public void addLast(T item) {
        Node newNode = new Node(item, sentinel.prev, sentinel);
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;
        size += 1;
    }

    @Override
    public T removeFirst() {
        // edge case: remove from empty deck
        if (isEmpty()) {
            return null;
        }

        Node firstNode = sentinel.next;
        sentinel.next =  sentinel.next.next;
        sentinel.next.prev = sentinel;
        size -= 1;
        return firstNode.item; // need to think about null case?
    }

    @Override
    public T removeLast() {
        // edge case: remove from empty deck
        if (isEmpty()) {
            return null;
        }

        Node lastNode = sentinel.prev;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        size -= 1;
        return lastNode.item;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
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

    private void set(int index, T setItem) {
        if (index >= size) {
            return;
        }
        Node ptr = sentinel.next;
        for (int i = 0; i < index; i++) {
            ptr = ptr.next;
        }
        ptr.item = setItem;
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
//    private T getRecursiveAnother(int index) {
//        // base case:
//        if (index >= size) {
//            return null;
//        } else if (index == 0) {
//            return sentinel.next.item;
//        } else {
//            // create a new deque (copy of the current deque)
//            LinkedListDeque<T> newlld = new LinkedListDeque<>(this);
//            newlld.removeFirstAnother(); // call this to pop first item from the newlld
//            return newlld.getRecursive(index - 1); // call recursively on the newlld
//        }
//    }

    /** Return item at certain index, starting from "start" node */
    private T getRecursiveHelper(Node start, int index) {
        // base case: index = 0
        if (index == 0) {
            return start.item;
        } else {
            // call recursive, move pointer 1 next for everytime
            // index decrease by 1, until reaches 0
            return getRecursiveHelper(start.next, index - 1);
        }
    }

    public T getRecursive(int index) {
        if (index >= size) {
            return null;
        }
        // call getRecursiveHelper() starting from "first" node
        return getRecursiveHelper(sentinel.next, index);
    }

    private T getFirst() {
        return sentinel.next.item;
    }

    private T getLast() {
        return sentinel.prev.item;
    }

    @Override
    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.print(get(i) + " ");
        }
        System.out.println();
    }
}
