public class ArrayDeque<T> {
    /** Array-based list implementation */
    private int size;
    private T[] items;

    // Default constructor
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
    }

    public void addFirst(T item) {
        return;
    }

    public void addLast(T item) {
        return;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.print(items[i]);
        }
        System.out.println();
    }

    public T removeFirst() {
        return;
    }

    public T removeLast() {
        return;
    }

    public T get(int index) {
        return;
    }
}