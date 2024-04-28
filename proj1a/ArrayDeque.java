public class ArrayDeque {
    /** Array-based list implementation */
    private int size;
    private int[] items;
    private int nextFirst; // index of the array when next addFirst will go to
    private int nextLast; // index of the array when next addLast will go to
    private double usageRatio;

    // Default constructor, create empty array deque
    public ArrayDeque() {
        items = new int[8]; // {0, 0, 0, 0, 0, 0, 0, 0}
        nextFirst = 3;
        nextLast = 4;
        size = 0;
        usageRatio = 0.0;
    }

    private void resize(int newSize) {
        int[] newArray = new int[newSize];
        System.arraycopy(this.items, 0, newArray, 0, size);
        this.items = newArray;
        usageRatio = size / items.length;
    }

    private void updateNextFirst() {
        if (nextFirst == size) {
            nextFirst = 0;
        }
        if (nextFirst == -1) {
            nextFirst = size - 1;
        }
    }

    private void updateNextLast() {
        if (nextLast == size) {
            nextLast = 0;
        }
        if (nextLast == -1) {
            nextLast = size - 1;
        }
    }

    public void addFirst(int item) {
        // check if run out of allocated memory box
        if (size == items.length) {
            resize(size * 2);
        }

        // how do we treat edge case, when nextFirst is already at 0 => need to loop forward to the end of array
        items[nextFirst] = item;

        nextFirst--; // push nextFirst forward by 1
        updateNextFirst();

        size++;
        usageRatio = size / items.length;
    }

    public void addLast(int item) {
        // check if run out of allocated memory box
        if (size == items.length) {
            resize(size * 2);
        }

        items[nextLast] = item;

        nextLast++; // push nextLast back by 1
        updateNextLast();

        size++;
        usageRatio = size / items.length;
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

    public int removeFirst() {
        // edge case, array deque is already empty, return null
        if (isEmpty()) {
            return -1;
        }

        int first = getFirst();

        // update the nextFirst pointer
        nextFirst = getFirstIndex();

        size--;
        usageRatio = size / items.length;
        return first;
    }

    public int removeLast() {
        if (isEmpty()) {
            return -1;
        }

        int last = getLast();

        // update the nextLast pointer
        nextLast = getLastIndex();

        size--;
        usageRatio = size / items.length;
        return last;
    }

    public int get(int index) {
        return items[index];
    }

    public int getFirst() {
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

    public int getLast() {
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
}