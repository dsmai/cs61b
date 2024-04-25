public class LinkedListDeque<T> {
    // Implement deque using linked list

    // instance variables
    private Node sentinel;
    private Node first;
    private Node last;
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
        Node sentinel = new Node(null, null, null); // What to pass in as first parameter here?
        first = null;
        last = null;
        size = 0;
    }

    // Another constructor, create with 1st element
    public LinkedListDeque(T item) {
        first = new Node(item, null, null);
        last = first;
        sentinel = new Node(null, last, first);
        first.prev = sentinel;
        size += 1;
    }

    public void addFirst(T item) {
        Node newNode = new Node(item, sentinel, first);
        sentinel.next = newNode;
        first.prev = newNode;
        first = newNode;
        size += 1;
    }

    public void addLast(T item) {
        Node newNode = new Node(item, last, null);
        last.next = newNode;
        sentinel.prev = newNode;
        last = newNode;
        size += 1;
    }

    public T removeFirst() {
        Node resultNode = first;
        sentinel.next = first.next;
        first.next.prev = sentinel;
        first = first.next;
        size -= 1;
        return resultNode.item; // need to think about null case?
    }

    public T removeLast() {
        Node resultNode = last;
        last.prev.next = null;
        sentinel.prev = last.prev;
        last = last.prev;
        size -= 1;
        return resultNode.item;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        if (index >= size) {
            return null;
        } else {
            int location = 0;
            // Create pointer reference to "first" of deque
            Node ptr = first;
            while (location < index) {
                location += 1;
                ptr = ptr.next;
            }
            return ptr.item;
        }
    }
}