public class ArraySet<Item> implements Set<Item> {
    // Set implementation using Array

    // Instance variable
    private Item[] items;
    private int size;
    private double usageRatio;

    // Default constructor
    public ArraySet() {
        items = (Item[]) new Object[4];
        size = 0;
        usageRatio = 0.0;
    }

    // Methods

    // private helper method to resize (up or down) array
    public void resize(int newSize) {
        Item[] newArray = (Item[]) new Object[newSize];

        // Copy to the new array
        System.arraycopy(this.items, 0, newArray, 0, size);

        // reassign the memory address, copy the bits
        this.items = newArray;

        // update usageRatio
        usageRatio = (double) size / newArray.length;
    }

    // O(n)
    // private helper method to return index of value
    // return -1 means the item is not in the set
    public int search_index(Item value) {
        for (int i = 0; i < size; i++) {
            if (items[i].equals(value)) { // use equals method for object comparison
                return i;
            }
        }
        return -1;
    }

    public double getUsageRatio() {
        return usageRatio;
    }

    public int getLength() {
        return items.length;
    }

    // O(1)
    @Override
    public int size() {
        return size;
    }

    // O(n) because it relies on contains()
    @Override
    public void add(Item value) {
        if (!contains(value)) {
            // check size
            // if not enough space, double the size
            if (size == items.length) {
                resize(items.length * 2);
            }

            items[size] = value;
            size++;
            usageRatio = (double) size / items.length;
        }
    }

    @Override
    public void remove(Item value) {
        // need to find the index of the item want to remove
        // then swap it with the last item
        // do items[index] = items[size - 1];
        // then null the last item
        // decrease size

        int index = search_index(value);
        if (index != -1) {
            items[index] = items[size - 1];
            items[size - 1] = null; // null the last item

            size--;
            usageRatio = (double) size / items.length;

            // size down array if necessary
            if (items.length >= 16 && usageRatio < 0.25) {
                resize(items.length / 2);
            }
        }
    }

    // This is linear time, O(n)
    @Override
    public boolean contains(Item value) {
        int index = -1;
        // loop through the entire array to check
        index = search_index(value);
        return index != -1;
    }

    // Remove all items, throw away the reference so garbage collector can collect
    @Override
    public void clear() {
        items = (Item[]) new Object[4];
        size = 0;
        usageRatio = 0.0;
    }
}
