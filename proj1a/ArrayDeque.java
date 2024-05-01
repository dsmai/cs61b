public class ArrayDeque<T> {
    /** Array-based list implementation */
    public int size;
    public T[] items;
    public int nextFirst; // index of the array when next addFirst will go to
    public int nextLast; // index of the array when next addLast will go to
    public double usageRatio;

    // Default constructor, create empty array deque
    public ArrayDeque() {
        items = (T[]) new Object[8]; // {0, 0, 0, 0, 0, 0, 0, 0}
        nextFirst = 3;
        nextLast = 4;
        size = 0;
        usageRatio = 0.0;
    }

    private void resize(int newSize) {
        T[] newArray = (T[]) new Object[newSize];
//        System.arraycopy(this.items, 0, newArray, 0, size);
        // Copy the old array to the new bigger array, start copying from index [nextFirst + 1] till [nextLast]
        int current = 0;
        for (int i = nextFirst + 1; current < size; i++) {
            if (i == items.length) {
                i = 0;
            }
            newArray[(newArray.length / 4) + current] = this.items[i];
            current++;
        }
        this.items = newArray;
        usageRatio = (double) size / items.length;
        // I forgot to do something with nextFirst and nextLast when resize?
        nextFirst = (newArray.length / 4) - 1;
        nextLast = (newArray.length - 1) - nextFirst;
    }

    private void updateNextFirst() {
        if (nextFirst == items.length) {
            nextFirst = 0;
        }
        if (nextFirst == -1) {
            nextFirst = items.length - 1;
        }
    }

    private void updateNextLast() {
        if (nextLast == items.length) {
            nextLast = 0;
        }
        if (nextLast == -1) {
            nextLast = items.length - 1;
        }
    }

    public void addFirst(T item) {
        // check if run out of allocated memory box
        if (size == items.length) {
            resize(size * 2);
        }

        // how do we treat edge case?
        // when nextFirst is already at 0
        // => need to loop forward to the end of array
        items[nextFirst] = item;

        nextFirst--; // push nextFirst forward by 1
        updateNextFirst();

        size++;
        usageRatio = (double) size / items.length;
    }

    public void addLast(T item) {
        // check if run out of allocated memory box
        if (size == items.length) {
            resize(size * 2);
        }

        items[nextLast] = item;

        nextLast++; // push nextLast back by 1
        updateNextLast();

        size++;
        usageRatio = (double) size / items.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        // Have to print from nextFirst + 1 to nextLast - 1
        int current = 0;

        for (int i = nextFirst + 1; current < size; i++) {
            if ( i == items.length) {
                i = 0;
            }
            System.out.print(items[i] + " ");
            current++;
        }
        System.out.println();
    }

    public T removeFirst() {
        // edge case, array deque is already empty, return null
        if (isEmpty()) {
            return null;
        }

        T first = getFirst();

        // update the nextFirst pointer
        nextFirst = getFirstIndex();

        // null it
        items[nextFirst] = null;

        size--;
        usageRatio = (double) size / items.length;
        return first;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }

        T last = getLast();

        // update the nextLast pointer
        nextLast = getLastIndex();

        // null it
        items[nextLast] = null;

        size--;
        usageRatio = (double) size / items.length;
        return last;
    }

    public T get(int index) {
        return items[index];
    }

    private T getFirst() {
        // what if nextFirst is already at the end, or (size - 1) index
        if (nextFirst == size - 1) {
            return items[0];
        } else {
            return items[nextFirst + 1];
        }
    }

    private int getFirstIndex() {
        // what if nextFirst is already at the end, or (size - 1) index
        if (nextFirst == size - 1) {
            return 0;
        } else {
            return nextFirst + 1;
        }
    }

    private T getLast() {
        // what if nextLast is already at the beginning, or 0 index
        if (nextLast == 0) {
            return items[size - 1];
        } else {
            return items[nextLast - 1];
        }
    }

    private int getLastIndex() {
        // what if nextLast is already at the beginning, or 0 index
        if (nextLast == 0) {
            return size - 1;
        } else {
            return nextLast - 1;
        }
    }

    public int getLength() {
        return items.length;
    }

    public double getUsageRatio() {
        return usageRatio;
    }
}
