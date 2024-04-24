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
    }

    public void addFirst(int number) {
        first = new IntNode(number, first);
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
}