public interface Deque<T> {
    // Declare Deque interface or contract for its subclasses
    public void addFirst(T item);
    public void addLast(T item);
    public boolean isEmpty();
    public int size();
    public void printDeque();
    public T removeFirst();
    public T removeLast();
    public T get(int index);
}
