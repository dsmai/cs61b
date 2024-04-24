public class SLList {
    // modify "first" to private so that it is more secure (cannot modify directly like L.first.next.next = L.first.next)
    // "first" now can only be accessed from the SLList
    private IntNode first;
    public IntNode last;
    public int size;

    // constructor
    public SLList(int number) {
        first = new IntNode(number, null);
        last = first;
        size = 1;
    }

    public void addFirst(int number) {
        last = first;
        first = new IntNode(number, first);
        size++;
    }

    public int getFirst() {
        return first.item;
    }

    public int getLast() {
        return last.item;
    }

    public void addLast(int number) {
        last.next = new IntNode(number, null);
    }

    public void addLastIterative(int number) {
        if (first != null) {
            IntNode ptr = first;

            // Advance pointer ptr to the end of the list
            while (ptr.next != null) {
                ptr = ptr.next;
            }
            // when out of while loop, we are at the last node
            ptr.next = new IntNode(number, null);
        } else {
            first = new IntNode(number, null);
        }

        size++;
    }

    public void addLastRecursive(int number) {
        if (first.next == null) {
            first.next = new IntNode(number, null);
        }
        first.next.addLastRecursive(number);

        size++;
    }

    public int size() {
        return size;
    }

    public int sizeIterative() {
        int totalSize = 0;
        IntNode ptr = first;
        while (ptr != null) {
            totalSize++;
            ptr = ptr.next;
        }
        return totalSize;
    }

    public int sizeRecursive() {
        // base case: .next is null, return 1
        if (first.next == null) {
            return 1;
        }
        return 1 + first.next.sizeRecursive();
    }
}