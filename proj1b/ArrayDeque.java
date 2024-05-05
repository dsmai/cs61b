public class ArrayDeque<T> implements Deque<T> {
    /** Array-based list implementation */
    private int size;
    private T[] items;
    private int nextFirst; // index of the array when next addFirst will go to
    private int nextLast; // index of the array when next addLast will go to
    private double usageRatio;

    /** Default constructor */
    public ArrayDeque() {
        items = (T[]) new Object[8]; // {0, 0, 0, 0, 0, 0, 0, 0}
        nextFirst = 3;
        nextLast = 4;
        size = 0;
        usageRatio = 0.0;
    }

    private int getLength() {
        return items.length;
    }

    private double getUsageRatio() {
        return usageRatio;
    }

    /**
     * Private helper method to resize (up or down)
     * @param newSize
     */
    private void resize(int newSize) {
        T[] newArray = (T[]) new Object[newSize];
        // System.arraycopy(this.items, 0, newArray, 0, size);

        // Copy the old array to the new bigger array,
        // starting copying from index [nextFirst + 1]
        for (int i = 0; i < size; i++) {
            newArray[(newArray.length / 4) + i] = this.get(i);
        }

        // make this.items now hold the memory address of newArray
        this.items = newArray;

        // Update usage ratio
        usageRatio = (double) size / items.length;

        // I forgot to do something with nextFirst and nextLast when resize?
        // Update nextFirst and nextLast with respect to newArray
        nextFirst = (newArray.length / 4) - 1;
        nextLast = nextFirst + size + 1;
    }

    /** Private helper method to update nextFirst */
    private void updateNextFirst() {
        nextFirst = (nextFirst + items.length) % items.length;
    }

    /** Private helper method to update nextLast */
    private void updateNextLast() {
        nextLast = (nextLast + items.length) % items.length;
    }

    private int getFirstIndex() {
        // what if nextFirst is already at the end, or (items.length - 1) index
        return (nextFirst + 1) % items.length;
    }

    private int getLastIndex() {
        // what if nextLast is already at the beginning, or 0 index
        return ((nextLast - 1) + items.length) % items.length;
    }

    private T getFirst() {
        // what if nextFirst is already at the end, or (items.length - 1) index
        return items[getFirstIndex()];
    }

    private T getLast() {
        // what if nextLast is already at the beginning, or 0 index
        return items[getLastIndex()];
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
    public void addFirst(T item) {
        // check if run out of allocated memory box
        // if yes, resize up
        if (size == items.length) {
            resize(items.length * 2);
        }

        items[nextFirst] = item;

        nextFirst--; // push nextFirst forward by 1

        // to check edge case (nextFirst = -1)
        updateNextFirst();

        // increase size
        size++;

        // update usage ratio
        usageRatio = (double) size / items.length;
    }

    @Override
    public void addLast(T item) {
        // check if run out of allocated memory box
        // if yes, resize up
        if (size == items.length) {
            resize(items.length * 2);
        }

        items[nextLast] = item;

        nextLast++; // push nextLast back by 1

        // to check edge case (nextLast = items.length)
        updateNextLast();

        // increase size
        size++;

        // update usage ratio
        usageRatio = (double) size / items.length;
    }

    /**
     * Get the item at the given index
     * Where 0 is the front, 1 is the next item
     * If no such item exists, or index >= size, return null
     * @param index
     * @return
     */
    @Override
    public T get(int index) {
        if (index >= size) {
            return null;
        }
        return items[(getFirstIndex() + index) % items.length];
    }

    @Override
    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.print(get(i) + " ");
        }
        System.out.println();
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }

        T first = getFirst();

        // null it
        items[getFirstIndex()] = null;

        // update the nextFirst pointer
        nextFirst = getFirstIndex();

        // decrease size
        size--;

        // update usage ratio
        usageRatio = (double) size / items.length;

        // halve the array length if usage ratio is below 0.25
        // for array of length 16 or more
        if (usageRatio < 0.25 && items.length >= 16) {
            resize(items.length / 2);
        }
        return first;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }

        T last = getLast();

        // null it
        items[getLastIndex()] = null;

        // update the nextLast pointer
        nextLast = getLastIndex();

        // decrease size
        size--;

        // update usage ratio
        usageRatio = (double) size / items.length;

        // halve the array length if usage ratio is below 0.25
        // for array of length 16 or more
        if (usageRatio < 0.25 && items.length >= 16) {
            resize(items.length / 2);
        }
        return last;
    }
}
